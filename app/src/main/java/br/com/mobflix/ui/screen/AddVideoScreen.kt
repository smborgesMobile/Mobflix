package br.com.mobflix.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.mobflix.R
import br.com.mobflix.designsystem.components.CategoryPills
import br.com.mobflix.designsystem.components.CustomEditText
import br.com.mobflix.ui.dimens.dimens
import br.com.mobflix.ui.theme.DarkBackgroundColor
import br.com.mobflix.ui.theme.DarkBlue
import coil.compose.AsyncImage

const val IMAGE_PATTERN = "https://i.ytimg.com/vi/%s/0.jpg"

@Composable
fun AppVideoScreen() {
    var imageUrl by remember { mutableStateOf("") }
    var category by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(DarkBackgroundColor)
            .verticalScroll(rememberScrollState())
    ) {
        Text(
            text = stringResource(R.string.video_header_title),
            color = Color.White,
            fontFamily = FontFamily(Font(R.font.roboto_bold)),
            fontSize = 32.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .padding(top = MaterialTheme.dimens.large)
        )

        CustomEditText(
            headerTitle = stringResource(R.string.url),
            placeHolderText = stringResource(R.string.ex_n3h5a0oazsk),
            modifier = Modifier.padding(top = MaterialTheme.dimens.large)
        ) {
            imageUrl = it
        }

        CustomEditText(
            headerTitle = stringResource(R.string.categoria),
            placeHolderText = stringResource(R.string.mobile_front_end),
            modifier = Modifier.padding(top = MaterialTheme.dimens.large)
        ) {
            category = it
        }
        Text(
            text = stringResource(R.string.preview),
            color = Color.White,
            fontFamily = FontFamily(Font(R.font.roboto_bold)),
            fontSize = 32.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .padding(top = MaterialTheme.dimens.large)
        )
        AsyncImage(
            model = imageUrl,
            contentDescription = String(),
            modifier = Modifier
                .padding(16.dp)
                .clip(RoundedCornerShape(10.dp))
                .fillMaxWidth()
                .height(180.dp),
            placeholder = painterResource(R.drawable.img_place_holder),
            error = painterResource(R.drawable.img_place_holder),
            contentScale = ContentScale.Crop
        )
        Button(
            onClick = {
                imageUrl = IMAGE_PATTERN.format(imageUrl)
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .background(DarkBackgroundColor),
            colors = ButtonDefaults.buttonColors(
                containerColor = DarkBlue
            ),
            shape = RoundedCornerShape(8.dp)
        ) {
            Text(
                text = stringResource(R.string.cadastrar),
                textAlign = TextAlign.Center,
                color = Color.White,
                fontFamily = FontFamily(Font(R.font.roboto_regular)),
                fontSize = 16.sp
            )
        }
    }
}

@Preview
@Composable
fun AppVideoPreview() {
    AppVideoScreen()
}