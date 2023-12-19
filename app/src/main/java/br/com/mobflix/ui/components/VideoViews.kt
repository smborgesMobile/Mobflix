package br.com.mobflix.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.mobflix.designsystem.components.CategoryPills
import br.com.mobflix.entities.VideoItemModel
import br.com.mobflix.ui.theme.LightRed
import coil.compose.AsyncImage

@Composable
fun VideoItemView(videoItemModel: VideoItemModel) {
    Column {
        CategoryPills(title = videoItemModel.category, color = LightRed)
        AsyncImage(
            model = videoItemModel.videoThumb,
            contentDescription = videoItemModel.category,
            modifier = Modifier
                .fillMaxWidth()
                .height(220.dp)
                .clip(RoundedCornerShape(24.dp))
                .padding(top = 8.dp, bottom = 16.dp),
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
fun VideoListView(modifier: Modifier = Modifier, videoList: List<VideoItemModel>) {
    Column(modifier = modifier) {
        videoList.forEach {
            VideoItemView(videoItemModel = it)
        }
    }
}

@Composable
@Preview
fun VideoItemViewPreview() {
    Column {
        VideoItemView(
            videoItemModel = VideoItemModel(
                category = "Front End",
                videoThumb = "https://i.ibb.co/5x0qfLH/Banner.png",
                videoUrl = "https://i.ibb.co/5x0qfLH/Banner.png"
            )
        )

        VideoListView(
            videoList = listOf(
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
                ), VideoItemModel(
                    category = "Front End",
                    videoThumb = "https://i.ibb.co/5x0qfLH/Banner.png",
                    videoUrl = "https://i.ibb.co/5x0qfLH/Banner.png"
                )
            )
        )
    }
}