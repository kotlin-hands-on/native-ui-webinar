package com.kmp.webinar

import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.ui.unit.dp
import androidx.compose.ui.layout.ContentScale
import coil.compose.AsyncImage
import country.Flags

@Composable
fun Flag(modifier: Modifier = Modifier, flag: Flags) {
    Card(
        modifier = modifier,
        elevation = 10.dp,
        shape = MaterialTheme.shapes.small
    ) {
        AsyncImage(
            model = flag.png,
            contentDescription = flag.alt,
            contentScale = ContentScale.FillBounds
        )
    }
}