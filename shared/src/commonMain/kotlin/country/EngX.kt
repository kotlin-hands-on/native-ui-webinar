package country

import kotlinx.serialization.Serializable

@Serializable
data class EngX(
    val common: String,
    val official: String
)