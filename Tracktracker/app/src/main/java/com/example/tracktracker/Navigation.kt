package com.example.tracktracker

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument


object Routes
{
    const val SCREEN_WELCOME = "WelcomeScreen"
    const val SCREEN_TRACK = "TrackScreen"
    const val SCREEN_TRACK_DAYS="TrackDaysScreen/{tracksId}"
    const val SCREEN_ADD_NEW_TRACK ="AddNewTrackScreen"
    const val SCREEN_ADD_NEW_TRACK_DAY ="AddNewTrackDayScreen/{tracksId}"

    fun getTrackPath(trackId: String?): String {
        return if (!trackId.isNullOrEmpty()) {
            "TrackDaysScreen/$trackId"
        } else {
            "TrackScreen"
        }
    }

@Composable
fun NavigationController( viewModel: TrackViewModel) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Routes.SCREEN_WELCOME) {
        composable(Routes.SCREEN_WELCOME) {
            WelcomeScreen(navController)
        }
        composable(Routes.SCREEN_TRACK ) {
            TrackScreen(navController,viewModel)
        }

        composable(Routes.SCREEN_ADD_NEW_TRACK) {
            AddNewTrackScreen(navController,viewModel)
        }

        composable(Routes.SCREEN_TRACK_DAYS,
            arguments = listOf(
                navArgument("tracksId") {
                    type = NavType.IntType
                }
            )
        ) {backStackEntry ->
            backStackEntry.arguments?.getInt("tracksId")?.let {
              TrackDaysScreen( navController, trackId=it,viewModel)
        }}

        composable(Routes.SCREEN_ADD_NEW_TRACK_DAY,
            arguments = listOf(
                navArgument("tracksId") {
                    type = NavType.IntType
                }
            )
            )
        { backStackEntry ->
            backStackEntry.arguments?.getInt("tracksId")?.let {
                AddNewTrackDayScreen(navController, trackId = it.toString(),viewModel)
            }
        }

    }
}
}
