package br.com.mobflix.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun AppVideoScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Blue)
    ) {

    }
}

@Preview
@Composable
fun AppVideoPreview() {
    AppVideoScreen()
}