package com.kmp.webinar

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import country.CapitalInfo

@Composable
fun WeatherButton(modifier: Modifier = Modifier, capitals: List<String>, capitalInfo: CapitalInfo, navigateToWeather: (String, Double, Double) -> Unit) {
    val navController = rememberNavController()
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.Bottom
    ) {
        Column {
            capitals.forEach {
                Button(
                    shape = RoundedCornerShape(20.dp),
                    colors = ButtonDefaults.outlinedButtonColors(
                        contentColor = Color.Black
                    ),
                    onClick = {
                        navigateToWeather(it, capitalInfo.latlng[0].toDouble(), capitalInfo.latlng[1].toDouble())
                    }) {
                    Text(text = "$it weather")
                }
            }
        }
    }
}