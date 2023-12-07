package com.nguyenhoangthanhan.learnjetpackcompose.navigation

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

sealed class Screen{
    data object HomeScreen: Screen()
    data object DelegationScreen: Screen()
}

object LearnJetpackComposeRouter{

    var currentScreen: MutableState<Screen> = mutableStateOf(Screen.HomeScreen)

    fun navigateTo(screen: Screen){
        currentScreen.value = screen
    }
}