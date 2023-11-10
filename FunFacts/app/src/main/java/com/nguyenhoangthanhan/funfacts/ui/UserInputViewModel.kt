package com.nguyenhoangthanhan.funfacts.ui

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.nguyenhoangthanhan.funfacts.data.UserDataUiEvents
import com.nguyenhoangthanhan.funfacts.data.UserInputScreenState

class UserInputViewModel : ViewModel() {

    companion object {
        const val TAG = "UserInputViewModel_TAG"
    }

    var uiState = mutableStateOf(UserInputScreenState())

    fun onEvent(event: UserDataUiEvents) {
        when (event) {
            is UserDataUiEvents.UserNameEntered -> {
                uiState.value = uiState.value.copy(
                    nameEntered = event.name
                )
                Log.d(TAG, "onEvent: UserNameEntered->")
                Log.d(TAG, "${uiState.value}")
            }

            is UserDataUiEvents.AnimalSelected -> {
                uiState.value = uiState.value.copy(
                    animateSelected = event.animalValue
                )
                Log.d(TAG, "onEvent: AnimalSelected->")
                Log.d(TAG, "${uiState.value}")
            }
        }
    }

//    fun isValidState
}