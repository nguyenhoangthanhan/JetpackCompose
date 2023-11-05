package com.nguyenhoangthanhan.loginflow.app

import android.util.Log
import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import com.nguyenhoangthanhan.loginflow.data.home.HomeViewModel
import com.nguyenhoangthanhan.loginflow.navigation.PostOfficeAppRouter
import com.nguyenhoangthanhan.loginflow.navigation.Screen
import com.nguyenhoangthanhan.loginflow.screens.HomeScreen
import com.nguyenhoangthanhan.loginflow.screens.LoginScreen
import com.nguyenhoangthanhan.loginflow.screens.SignUpScreen
import com.nguyenhoangthanhan.loginflow.screens.TermsAndConditionsScreen

@Composable
fun PostOfficeApp(homeViewModel: HomeViewModel = viewModel()) {

    homeViewModel.checkForActiveSession()

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.White
    ) {
        Log.d("ClickableTextComponent_Tag", "PostOfficeApp")

        if (homeViewModel.isUserLoggedIn.value == true) {
            PostOfficeAppRouter.navigateTo(Screen.HomeScreen)
        }

        Crossfade(targetState = PostOfficeAppRouter.currentScreen, label = "") { currentState ->
            Log.d("ClickableTextComponent_Tag", "Crossfade.currentState = $currentState")
            when (currentState.value) {
                is Screen.SignUpScreen -> {
                    Log.d("ClickableTextComponent_Tag", "Screen.SignUpScreen")
                    SignUpScreen()
                }

                is Screen.TermsAndConditionsScreen -> {
                    Log.d("ClickableTextComponent_Tag", "Screen.TermsAndConditionsScreen")
                    TermsAndConditionsScreen()
                }

                is Screen.LoginScreen -> {
                    Log.d("ClickableTextComponent_Tag", "Screen.LoginScreen")
                    LoginScreen()
                }

                is Screen.HomeScreen -> {
                    Log.d("ClickableTextComponent_Tag", "Screen.LoginScreen")
                    HomeScreen()
                }
            }
        }
    }
}