package br.com.mobflix.ui.screen.viewmodel

// Import necessary libraries
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
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
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import br.com.mobflix.R
import br.com.mobflix.designsystem.components.AppAlertDialog
import br.com.mobflix.designsystem.components.CategoryPills
import br.com.mobflix.designsystem.components.CustomEditText
import br.com.mobflix.ui.dimens.dimens
import br.com.mobflix.ui.theme.DarkBackgroundColor
import br.com.mobflix.ui.theme.DarkBlue
import br.com.mobflix.ui.theme.LightRed
import coil.compose.AsyncImage
import org.koin.androidx.compose.koinViewModel

const val IMAGE_PATTERN = "https://i.ytimg.com/vi/%s/0.jpg"

@Composable
fun AppVideoScreen(
    navController: NavHostController,
    appVideoViewModel: AddVideoScreenViewModel = koinViewModel()
) {
    val state by appVideoViewModel.addVideoState.collectAsState()

    var imageUrl by remember { mutableStateOf("") }
    var category by remember { mutableStateOf("") }
    var isVisible by remember { mutableStateOf(false) }
    val openAlertDialog = remember { mutableStateOf(false) }

    when {
        openAlertDialog.value -> {
            AppAlertDialog(
                onDismissRequest = {
                    openAlertDialog.value = false
                },
                onConfirmation = {
                    openAlertDialog.value = false
                    navController.popBackStack()
                },
                dialogTitle = stringResource(R.string.there_is_no_data_selected),
                dialogText = stringResource(R.string.you_have_unsaved_changes_are_you_sure_you_want_to_leave),
                icon = Icons.Default.Info
            )
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(DarkBackgroundColor)
            .verticalScroll(rememberScrollState())
    ) {
        // Header
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

        // URL Input
        CustomEditText(
            headerTitle = stringResource(R.string.url),
            placeHolderText = stringResource(R.string.ex_n3h5a0oazsk),
            modifier = Modifier.padding(top = MaterialTheme.dimens.large)
        ) {
            imageUrl = it
        }

        // Category Input
        CustomEditText(
            headerTitle = stringResource(R.string.categoria),
            placeHolderText = stringResource(R.string.mobile_front_end),
            modifier = Modifier.padding(top = MaterialTheme.dimens.large)
        ) {
            category = it
            isVisible = category.isNotEmpty()
        }

        // Display Category Pills if category is not empty
        if (isVisible) {
            CategoryPills(
                title = category,
                color = LightRed,
                modifier = Modifier.padding(start = 16.dp, top = 8.dp)
            )
        }

        // Preview Image
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

        // Submit Button
        Button(
            onClick = {
                appVideoViewModel.processIntent(AddVideoIntent.SaveVideo(imageUrl, category))
                imageUrl = IMAGE_PATTERN.format(imageUrl)
                if (imageUrl.isNotEmpty() && category.isNotEmpty()) {
                    navController.popBackStack()
                } else {
                    openAlertDialog.value = true
                }
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
    AppVideoScreen(rememberNavController(), viewModel())
}