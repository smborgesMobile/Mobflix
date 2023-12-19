package br.com.mobflix.designsystem.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.mobflix.ui.theme.LightBlue
import coil.compose.AsyncImage

@Composable
fun LargeBanner(
    imageUrl: String,
    contentDescription: String = "",
    pillText: String
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(138.dp)
    ) {
        AsyncImage(
            model = imageUrl,
            contentDescription = contentDescription,
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.Crop
        )
    }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .offset(y = (-50).dp)
            .fillMaxWidth()
    ) {
        CategoryPills(title = pillText, color = LightBlue)
    }
}

@Preview
@Composable
fun LargeBannerPreview() {
    LargeBanner(
        imageUrl = "https://i.ibb.co/5x0qfLH/Banner.png",
        pillText = "Front End"
    )
}