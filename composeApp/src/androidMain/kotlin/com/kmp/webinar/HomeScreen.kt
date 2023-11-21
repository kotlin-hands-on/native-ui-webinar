package com.kmp.webinar

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import cache.CountrySDK
import country.Country

@Composable
fun HomeScreen(navigateToWeather: (String, Double, Double) -> Unit) {
    Surface {
        var listCountries: List<Country> by remember { mutableStateOf(mutableListOf()) }

        LaunchedEffect(Unit) {
            listCountries = CountrySDK().getCountries()
        }

        Column {
            LazyColumn() {
                itemsIndexed(items = listCountries) { index, item ->
                    CountryCard(
                        modifier = Modifier,
                        country = item,
                        currentCountry = index == 0,
                        navigateToWeather
                    )
                }
            }
        }
    }
}
