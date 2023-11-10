package com.nguyenhoangthanhan.funfacts.ui

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class UserInputViewModel : ViewModel() {

    var uiState = mutableStateOf(UserInputScreenState())

}

data class UserInputScreenState(
    var nameEntered: String = "",
    var animateSelected: String = ""
)

sealed class UserDataUiEvents{
    data class UserNameEntered(val name: String) : UserDataUiEvents()
    data class AnimalSelected(val animalValue: String) : UserDataUiEvents()
}