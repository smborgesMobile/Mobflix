package br.com.mobflix

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.mobflix.designsystem.components.CategoryPills
import br.com.mobflix.designsystem.components.Fab
import br.com.mobflix.designsystem.components.LargeBanner
import br.com.mobflix.designsystem.components.ScreenHeader
import br.com.mobflix.entities.VideoItemModel
import br.com.mobflix.ui.components.VideoListView
import br.com.mobflix.ui.dimens.dimens
import br.com.mobflix.ui.theme.DarkBackgroundColor
import br.com.mobflix.ui.theme.Green
import br.com.mobflix.ui.theme.LightBlue
import br.com.mobflix.ui.theme.LightRed
import br.com.mobflix.ui.theme.MyApplicationTheme

@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {

    private val videoList: List<VideoItemModel> = listOf(
        VideoItemModel(
            category = "Front End",
            videoThumb = "https://i.ibb.co/5x0qfLH/Banner.png",
            videoUrl = "https://i.ibb.co/5x0qfLH/Banner.png"
        ),
        VideoItemModel(
            category = "Front End",
            videoThumb = "https://i.ibb.co/5x0qfLH/Banner.png",
            videoUrl = "https://i.ibb.co/5x0qfLH/Banner.png"
        ),
        VideoItemModel(
            category = "Front End",
            videoThumb = "https://i.ibb.co/5x0qfLH/Banner.png",
            videoUrl = "https://i.ibb.co/5x0qfLH/Banner.png"
        ),
        VideoItemModel(
            category = "Front End",
            videoThumb = "https://i.ibb.co/5x0qfLH/Banner.png",
            videoUrl = "https://i.ibb.co/5x0qfLH/Banner.png"
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {

                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = DarkBackgroundColor
                ) {
                    Scaffold(
                        topBar = {},
                        floatingActionButton = {
                            Fab()
                        }
                    ) { padding ->
                        Column(modifier = Modifier.background(DarkBackgroundColor)) {
                            ScreenHeader(title = "MOBFLIX")
                            Column(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .verticalScroll(rememberScrollState())
                                    .padding(padding)
                            ) {
                                LargeBanner(
                                    imageUrl = "https://i.ibb.co/5x0qfLH/Banner.png",
                                    pillText = "Assista Agora"
                                )
                                PillList()
                                VideoListView(
                                    videoList = videoList, modifier = Modifier.padding(
                                        horizontal = 16.dp,
                                        vertical = 28.dp
                                    )
                                )
                            }
                        }

                    }
                }
            }
        }
    }

    @Composable
    fun PillList(modifier: Modifier = Modifier) {
        val scrollState = rememberScrollState()
        Row(
            modifier = modifier
                .horizontalScroll(scrollState)
        ) {
            Spacer(modifier = Modifier.width(MaterialTheme.dimens.medium))
            CategoryPills(
                title = stringResource(R.string.front_end),
                color = LightBlue
            )
            Spacer(modifier = Modifier.width(MaterialTheme.dimens.small))
            CategoryPills(
                title = stringResource(R.string.programa_o),
                color = Green
            )
            Spacer(modifier = Modifier.width(MaterialTheme.dimens.small))
            CategoryPills(
                title = stringResource(R.string.mobile),
                color = LightRed
            )
            Spacer(modifier = Modifier.width(MaterialTheme.dimens.small))
            CategoryPills(
                title = stringResource(id = R.string.front_end),
                color = LightBlue
            )
            Spacer(modifier = Modifier.width(MaterialTheme.dimens.small))
            CategoryPills(
                title = stringResource(id = R.string.programa_o),
                color = Green
            )
            Spacer(modifier = Modifier.width(MaterialTheme.dimens.small))
            CategoryPills(
                title = stringResource(id = R.string.mobile),
                color = LightRed
            )
            Spacer(modifier = Modifier.width(MaterialTheme.dimens.medium))
        }
    }

    @Preview
    @Composable
    fun PillListPreview() {
        Scaffold(
            modifier = Modifier.background(DarkBackgroundColor)
        ) { padding ->
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(DarkBackgroundColor)
            ) {
                ScreenHeader(title = "MOBFLIX")
                LargeBanner(
                    imageUrl = "https://i.ibb.co/5x0qfLH/Banner.png",
                    pillText = "Assista Agora"
                )
                PillList()
                VideoListView(
                    videoList = videoList,
                    modifier = Modifier.padding(
                        horizontal = 16.dp,
                        vertical = 28.dp
                    )
                )
                Fab()
            }
        }
    }
}