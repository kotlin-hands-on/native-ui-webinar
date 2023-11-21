package country

import kotlinx.serialization.Serializable

@Serializable
data class CapitalInfo(
    val latlng: List<Double> = listOf(0.0, 0.0)
)