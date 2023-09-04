package com.example.composenavigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument


@Composable
fun SetNavigationGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(Screen.Home.route) {
            HomeScreen(navController = navController)
        }
        composable(Screen.Detail.route,
            arguments = listOf(
                navArgument(DETAIL_SCREEN_KEY1) {
                    type = NavType.IntType
                    defaultValue =0
                },
                navArgument(DETAIL_SCREEN_KEY2) {
                    type = NavType.StringType
                }
            )
        ) {
            Log.d("Arguments",it.arguments?.getInt(DETAIL_SCREEN_KEY1).toString())
            Log.d("Arguments",it.arguments?.getString(DETAIL_SCREEN_KEY2).toString())
            DetailScreen(navController = navController)
        }
    }
}