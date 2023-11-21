package com.kmp.webinar

import androidx.compose.foundation.border
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.material.Card
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import country.Country
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.Color
import androidx.compose.material.MaterialTheme

@Composable
fun CountryCard(modifier: Modifier, country: Country, currentCountry: Boolean, navigateToWeather: (String, Double, Double)-> Unit) {
    Card(
        modifier = modifier.fillMaxWidth().padding(4.dp),
        elevation = 10.dp,
        shape = MaterialTheme.shapes.medium,
        ) {
        if (currentCountry) {
            Box(modifier = Modifier.border(5.dp, Color.DarkGray)) {
                Country(Modifier, country, navigateToWeather)
            }
        } else {
            Country(Modifier, country, navigateToWeather)
        }
    }
}