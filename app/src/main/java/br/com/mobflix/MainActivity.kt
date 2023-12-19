package br.com.mobflix

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.mobflix.designsystem.components.Fab
import br.com.mobflix.designsystem.components.LargeBanner
import br.com.mobflix.designsystem.components.ScreenHeader
import br.com.mobflix.entities.VideoItemModel
import br.com.mobflix.ui.components.VideoListView
import br.com.mobflix.ui.navigation.ComposeNavigation
import br.com.mobflix.ui.screen.PillList
import br.com.mobflix.ui.theme.DarkBackgroundColor
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
                    ComposeNavigation(videoList)
                }
            }
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
                    .padding(padding)
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
                Fab {

                }
            }
        }
    }
}