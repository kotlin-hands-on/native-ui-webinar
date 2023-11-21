package com.kmp.webinar

import androidx.compose.runtime.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import network.WeatherApi
import weather.Weather
import weather.celsiusToFahrenheit


@Composable
fun WeatherCard(modifier: Modifier, cityName: String, lat: Double, long: Double) {
    var weather: Weather? by remember { mutableStateOf(null) }

    LaunchedEffect(Unit) {
        weather = WeatherApi().getWeather(lat, long)
    }


    weather?.let { weather ->
        Card(
            modifier = modifier.fillMaxWidth().padding(4.dp),
            elevation = 10.dp,
            shape = MaterialTheme.shapes.medium
        ) {
            Column(modifier = Modifier.padding(8.dp)) {
                Text(
                    modifier = Modifier.align(CenterHorizontally),
                    text = cityName,
                    style = MaterialTheme.typography.h4
                )
                AsyncImage(
                    modifier = Modifier.width(128.dp).height(128.dp).align(CenterHorizontally),
                    model = "https://openweathermap.org/img/wn/${weather.weather[0].icon}@2x.png",
                    contentDescription = weather.weather[0].description,
                    contentScale = ContentScale.Fit
                )
                Text(
                    "Feels like: ${weather.main.feels_like} 'C / ${celsiusToFahrenheit(weather.main.feels_like)} 'F",
                    style = MaterialTheme.typography.body1
                )
                Text(
                    "Temp: ${weather.main.temp} 'C / ${celsiusToFahrenheit(weather.main.temp)} 'F",
                    style = MaterialTheme.typography.body1
                )
            }
        }
    }
}