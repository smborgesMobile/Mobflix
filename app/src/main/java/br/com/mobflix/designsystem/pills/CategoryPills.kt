package br.com.mobflix.designsystem.pills

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.mobflix.R
import br.com.mobflix.ui.dimens.dimens

@Composable
fun CategoryPills(title: String, color: Color) {
    Box(
        modifier = Modifier
            .clip(MaterialTheme.shapes.small)
            .background(color = color)
            .padding(MaterialTheme.dimens.small)
    ) {
        Text(
            text = title,
            fontSize = 16.sp,
            fontFamily = FontFamily(Font(R.font.roboto_regular)),
            color = Color.White
        )
    }
}

@Preview
@Composable
fun CategoryPillsPreview() {
    Column(modifier = Modifier.padding(8.dp)) {
        CategoryPills(title = "Front End", color = Color.Blue)
        Spacer(modifier = Modifier.height(8.dp))
        CategoryPills(title = "Programação", color = Color.Green)
        Spacer(modifier = Modifier.height(8.dp))
        CategoryPills(title = "Mobile", color = Color.Red)
        Spacer(modifier = Modifier.height(8.dp))
        CategoryPills(title = "Mobile", color = Color.Cyan)
    }
}