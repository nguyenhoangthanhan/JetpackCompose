package com.nguyenhoangthanhan.newsinshort.ui.navigation


import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.nguyenhoangthanhan.newsinshort.ui.screens.HomeScreen

@Composable
fun AppNavigationGraph() {

    val navController = rememberNavController()
    NavHost(
        navController = navController, startDestination = Routes.HOME_SCREEN
    ) {
        composable(Routes.HOME_SCREEN){
            HomeScreen()
        }
    }
}