package com.kmp.webinar

import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier


@Composable
fun WeatherScreen(cityName: String, lat: Double, long: Double) {
    Surface {
        WeatherCard(
            modifier = Modifier,
            cityName = cityName,
            lat = lat,
            long = long
        )
    }
}