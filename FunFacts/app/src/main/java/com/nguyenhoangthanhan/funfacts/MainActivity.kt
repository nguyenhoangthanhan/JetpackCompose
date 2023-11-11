package com.nguyenhoangthanhan.funfacts

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.nguyenhoangthanhan.funfacts.ui.theme.FunFactsTheme
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.nguyenhoangthanhan.funfacts.ui.screens.FunFactsNavigationGraph
import com.nguyenhoangthanhan.funfacts.ui.screens.Routes
import com.nguyenhoangthanhan.funfacts.ui.screens.UserInputScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContent {
            FunFactsTheme {
                FunFactsApp()
            }
        }
    }

    @Composable
    fun FunFactsApp() {
        FunFactsNavigationGraph()
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FunFactsTheme {

    }
}