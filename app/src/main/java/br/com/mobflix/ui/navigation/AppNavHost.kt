package br.com.mobflix.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.mobflix.entities.VideoItemModel
import br.com.mobflix.ui.screen.HomeScreen
import br.com.mobflix.ui.screen.viewmodel.AppVideoScreen

@Composable
fun ComposeNavigation(videoItemList: List<VideoItemModel>) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "Home") {
        composable(AppNavRoute.HOME.route) {
            HomeScreen(videoItemList, navController)
        }
        composable(AppNavRoute.NEW_VIDEO.route) {
            AppVideoScreen(navController)
        }
    }
}

@Preview
@Composable
fun ComposeNavigationPreview() {
    ComposeNavigation(videoItemList = listOf())
}