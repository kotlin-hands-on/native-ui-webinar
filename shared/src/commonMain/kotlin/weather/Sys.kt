package weather

import kotlinx.serialization.Serializable

@Serializable
data class Sys(
    val country: String = "",
    val id: Int = 0,
    val sunrise: Int,
    val sunset: Int,
    val type: Int = 0
)