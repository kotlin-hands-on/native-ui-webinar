package com.kmp.webinar

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import country.Country

@Composable
fun CountryCard(
    modifier: Modifier,
    country: Country,
    currentCountry: Boolean,
    navigateToWeather: (String, Double, Double) -> Unit
) {
    Box(modifier = modifier
        .fillMaxWidth()
        .padding(4.dp)) {
        if (currentCountry) {
            Box(modifier = Modifier.border(5.dp, Color.DarkGray)) {
                Country(Modifier, country, navigateToWeather)
            }
        } else {
            Country(Modifier, country, navigateToWeather)
        }
    }
}