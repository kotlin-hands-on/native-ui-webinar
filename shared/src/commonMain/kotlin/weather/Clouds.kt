package weather

import kotlinx.serialization.Serializable

@Serializable
data class Clouds(
    val all: Int
)