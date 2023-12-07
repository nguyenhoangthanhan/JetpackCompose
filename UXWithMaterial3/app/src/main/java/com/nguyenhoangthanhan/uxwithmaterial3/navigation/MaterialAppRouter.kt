package com.nguyenhoangthanhan.uxwithmaterial3.navigation

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

sealed class Screen {

    data object HomeScreen : Screen()
    data object ButtonScreen : Screen()
    data object TextFieldsScreen : Screen()
    data object SelectionUIComponentsScreen : Screen()
    data object TopAppBarToolbarScreen : Screen()
    data object BottomAppBarScreen : Screen()
    data object BottomNavigationBarWithBadgesScreen : Screen()
    data object NavigationRailScreen : Screen()
    data object NavigationDrawerScreen : Screen()
    data object BottomSheetsScreen : Screen()
}

object MaterialAppRouter {

    var currentScreen: MutableState<Screen> = mutableStateOf(Screen.HomeScreen)

    fun navigateTo(destination: Screen) {
        Log.d("ClickableTextComponent_Tag", "navigateTo.destination = $destination")
        currentScreen.value = destination
    }

}