package weather

import kotlinx.serialization.Serializable

@Serializable
data class Wind(
    val deg: Int,
    val speed: Double,
    val gust: Double = 0.0
)