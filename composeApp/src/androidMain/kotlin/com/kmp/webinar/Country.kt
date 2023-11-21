package com.kmp.webinar

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import country.Country

@Composable
fun Country(modifier: Modifier, country: Country, navigateToWeather: (String, Double, Double)-> Unit) {
    Row(modifier = Modifier.padding(8.dp)) {
        Column(modifier = Modifier.width(130.dp)) {
            Flag(modifier = Modifier.fillMaxWidth().padding(8.dp), country.flags)
        }
        Column(modifier = Modifier.fillMaxWidth().padding(8.dp)) {
            CountryNames(name = country.name)
            val capitalInfo = country.capitalInfo
            if (country.capital.isNotEmpty() && capitalInfo != null) {
                WeatherButton(capitals = country.capital, capitalInfo = capitalInfo,
                    navigateToWeather = navigateToWeather
                )
            }
        }
    }
}