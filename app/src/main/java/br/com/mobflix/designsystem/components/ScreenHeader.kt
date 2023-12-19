package br.com.mobflix.designsystem.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import br.com.mobflix.R
import br.com.mobflix.ui.dimens.dimens
import br.com.mobflix.ui.theme.LightBlue

@Composable
fun ScreenHeader(title: String) {
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = title,
            color = LightBlue,
            modifier = Modifier
                .fillMaxWidth()
                .padding(MaterialTheme.dimens.small),
            textAlign = TextAlign.Center,
            fontSize = 32.sp,
            fontFamily = FontFamily(Font(R.font.bebas_nue))
        )
    }
}

@Composable
@Preview
fun ScreenHeaderPreview() {
    ScreenHeader(title = "MOBFLIX")
}