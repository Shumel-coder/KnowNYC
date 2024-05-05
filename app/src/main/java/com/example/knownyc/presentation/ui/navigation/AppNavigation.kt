package com.example.knownyc.presentation.ui.navigation

import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.knownyc.presentation.boroughs.BoroughCardPreview
import com.example.knownyc.presentation.boroughs.BoroughScreen

@Composable
fun AppNavigationGraph() {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Routes.HOME_SCREEN) {

        composable(Routes.HOME_SCREEN) {
            BoroughScreen(onBoroughClicked = {borough, title ->
            //TODO navigate to parks screen
                navController.navigate(Routes.PARKS_SCREEN)
            })
        }

        composable(Routes.PARKS_SCREEN) {

        }
    }
}