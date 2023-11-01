package com.nguyenhoangthanhan.loginflow.data

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.nguyenhoangthanhan.loginflow.data.rules.Validator

class LoginViewModel : ViewModel() {

    private val TAG = "LoginViewModel_TAG"

    var registrationUIState = mutableStateOf(RegistrationUIState())

    fun onEvent(event: UIEvent) {
        validateDataWithRules()
        when (event) {
            is UIEvent.FirstNameChanged -> {
                registrationUIState.value = registrationUIState.value.copy(
                    firstName = event.firstName
                )
                printState()
            }

            is UIEvent.LastNameChanged -> {
                registrationUIState.value = registrationUIState.value.copy(
                    lastName = event.lastName
                )
                printState()
            }

            is UIEvent.EmailChanged -> {
                registrationUIState.value = registrationUIState.value.copy(
                    email = event.email
                )
                printState()
            }

            is UIEvent.PasswordChanged -> {
                registrationUIState.value = registrationUIState.value.copy(
                    password = event.password
                )
                printState()
            }

            is UIEvent.RegisterButtonClicked -> {
                signUp()
            }
        }
    }

    private fun signUp() {
        Log.d(TAG, "Inside_signUp")
        printState()

        validateDataWithRules()

    }

    private fun validateDataWithRules() {
        Log.d(TAG, "Inside_validateDataWithRules")
        val fNameResult = Validator.validateFirstName(
            firstName = registrationUIState.value.firstName
        )
        val lastNameResult = Validator.validateLastName(
            lastName = registrationUIState.value.lastName
        )
        val emailResult = Validator.validateEmail(
            email = registrationUIState.value.email
        )
        val passwordResult = Validator.validatePassword(
            password = registrationUIState.value.password
        )
        Log.d(TAG, "firstName = $fNameResult")
        Log.d(TAG, "firstName = $lastNameResult")
        Log.d(TAG, "firstName = $emailResult")
        Log.d(TAG, "firstName = $passwordResult")

        registrationUIState.value = registrationUIState.value.copy(
            firstNameError = fNameResult.status,
            lastNameError = lastNameResult.status,
            emailError = emailResult.status,
            passwordError = passwordResult.status
        )
    }

    private fun printState(){
        Log.d(TAG, "Inside_printState")
        Log.d(TAG, registrationUIState.value.toString())
    }
}