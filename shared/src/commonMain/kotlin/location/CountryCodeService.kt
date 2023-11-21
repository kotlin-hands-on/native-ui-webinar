package location
interface CountryCodeService {
    fun getCountryCode(): String?
}
expect fun getCountryCodeService(): CountryCodeService