package com.kmp.webinar

import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.material.MaterialTheme
import country.Name

@Composable
fun CountryNames(modifier: Modifier = Modifier, name: Name) {
    Column(modifier = modifier) {
        Text(text = name.common, style = MaterialTheme.typography.body1)
        Text(text = name.official, style = MaterialTheme.typography.body2)
    }
}