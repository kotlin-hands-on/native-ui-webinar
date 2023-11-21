package network

import com.rickclephas.kmp.nativecoroutines.NativeCoroutines
import country.Country
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.cache.HttpCache
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

class CountryApi {
    private val httpClient = HttpClient {
        install(ContentNegotiation) {
            json(Json {
                encodeDefaults = true
                isLenient = true
                coerceInputValues = true
                ignoreUnknownKeys = true
            })
        }
    }

    @NativeCoroutines
    suspend fun getAllCountries(): List<Country> {
        return httpClient.get("https://restcountries.com/v3.1/all").body<List<Country>>().sortedBy { it.name.common }
    }
}