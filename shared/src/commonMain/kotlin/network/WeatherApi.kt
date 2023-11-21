package network

import com.kmp.webinar.Config
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn
import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import kotlinx.serialization.json.Json
import weather.Weather
import kotlin.time.Duration.Companion.seconds
import com.rickclephas.kmp.nativecoroutines.NativeCoroutines

class WeatherApi() {
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
    suspend fun getWeather(lat: Double, long: Double):Weather {
        return httpClient.get("https://api.openweathermap.org/data/2.5/weather?lat=${lat}&lon=${long}&appid=${Config.WeatherApiKey}&units=metric")
            .body()
    }

    private val clockTime = flow<String> {
        while(true) {
            emit(formatTime(Clock.System.now()))
            delay(1.seconds)
        }
    }

    val actualTime = clockTime.stateIn(GlobalScope, SharingStarted.Eagerly, "N/A")

    private fun formatTime(time: Instant): String {
        val localDateTime = time.toLocalDateTime(TimeZone.UTC)
        return "${localDateTime.hour}:${localDateTime.minute}:${localDateTime.second}"
    }
}