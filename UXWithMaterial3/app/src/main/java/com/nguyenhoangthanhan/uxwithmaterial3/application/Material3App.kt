package com.nguyenhoangthanhan.uxwithmaterial3.application

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.nguyenhoangthanhan.uxwithmaterial3.navigation.MaterialAppRouter
import com.nguyenhoangthanhan.uxwithmaterial3.navigation.Screen
import com.nguyenhoangthanhan.uxwithmaterial3.ui.screens.ButtonScreen
import com.nguyenhoangthanhan.uxwithmaterial3.ui.screens.HomeScreen
import com.nguyenhoangthanhan.uxwithmaterial3.ui.screens.TextFieldsScreen

@Composable
fun Material3App (){
    Surface (
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ){
        Crossfade(targetState = MaterialAppRouter.currentScreen, label = "") { currentScreen ->
            when(currentScreen.value){
                is Screen.HomeScreen -> {
                    HomeScreen()
                }

                is Screen.ButtonScreen -> {
                    ButtonScreen()
                }

                is Screen.TextFieldsScreen -> {
                    TextFieldsScreen()
                }
            }
        }
    }
}