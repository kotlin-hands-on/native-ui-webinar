package cache

import com.rickclephas.kmp.nativecoroutines.NativeCoroutines
import country.Country
import io.github.xxfast.kstore.KStore
import io.github.xxfast.kstore.file.storeOf
import network.CountryApi
import location.getCountryCodeService

class CountrySDK {
    private val cache: KStore<List<Country>> = storeOf(filePath = pathToCountryCache())
    private val api: CountryApi = CountryApi()

    @NativeCoroutines
    @Throws(Exception::class)
    suspend fun getCountries(): List<Country> {
        val countryCode = getCountryCodeService().getCountryCode()

        val tempCountries = getSortedCountries().toMutableList()
        val currentCountry = tempCountries.first { it.cca2 == countryCode }
        tempCountries.remove(currentCountry)
        tempCountries.add(0, currentCountry)
        return tempCountries
    }

    private suspend fun getSortedCountries(): List<Country>{
        return cache.get()
                ?: api.getAllCountries().also {
                    cache.set(it)
                }
    }
}

expect fun pathToCountryCache(): String