package com.kmp.webinar

import android.annotation.SuppressLint
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun App() {
    MaterialTheme {
        val navController = rememberNavController()
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text("Weather App") },
                    navigationIcon = {
                        if (currentRoute?.startsWith("weather") == true) {
                            IconButton(onClick = { navController.navigateUp() }) {
                                Icon(
                                    imageVector = Icons.Filled.ArrowBack,
                                    contentDescription = "Localized description"
                                )
                            }
                        }
                    }
                )
            }
        ) {
            NavHost(navController = navController, startDestination = "home") {
                composable("home") {
                    HomeScreen { cityName, lat, long ->
                        navController.navigate("weather?cityName=$cityName&lat=$lat&long=$long")
                    }
                }
                composable(
                    "weather?cityName={cityName}&lat={lat}&long={long}",
                    arguments = listOf(
                        navArgument("cityName") {
                            type = NavType.StringType; defaultValue = "Unknown"
                        },
                        navArgument("lat") {
                            type = NavType.FloatType; defaultValue = 0.0
                        },
                        navArgument("long") {
                            type = NavType.FloatType; defaultValue = 0.0
                        })
                ) {
                    WeatherScreen(
                        it.arguments?.getString("cityName")!!,
                        it.arguments?.getFloat("lat")!!.toDouble(),
                        it.arguments?.getFloat("long")!!.toDouble()
                    )
                }
            }
        }
    }
}