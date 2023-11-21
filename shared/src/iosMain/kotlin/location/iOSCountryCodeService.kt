package location

import platform.Foundation.NSLocale
import platform.Foundation.NSLocaleCountryCode
import platform.Foundation.currentLocale

class iOSCountryCodeService() : CountryCodeService {
    override fun getCountryCode(): String? {
        return NSLocale.currentLocale().objectForKey(NSLocaleCountryCode).toString()
    }
}

actual fun getCountryCodeService(): CountryCodeService = iOSCountryCodeService()