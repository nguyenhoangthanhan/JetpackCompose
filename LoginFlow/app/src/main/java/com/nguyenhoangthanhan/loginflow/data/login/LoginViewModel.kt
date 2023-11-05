package com.nguyenhoangthanhan.loginflow.data.login

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.nguyenhoangthanhan.loginflow.data.login.LoginUIEvent
import com.nguyenhoangthanhan.loginflow.data.login.LoginUIState
import com.nguyenhoangthanhan.loginflow.data.rules.Validator
import com.nguyenhoangthanhan.loginflow.navigation.PostOfficeAppRouter
import com.nguyenhoangthanhan.loginflow.navigation.Screen

class LoginViewModel : ViewModel() {

    private val TAG = "LoginViewModel_TAG"

    var loginUIState = mutableStateOf(LoginUIState())

    var allValidationsPassed = mutableStateOf(false)

    var loginInProgress = mutableStateOf(false)

    fun onEvent(event: LoginUIEvent) {
        when (event) {
            is LoginUIEvent.EmailChanged -> {
                loginUIState.value = loginUIState.value.copy(
                    email = event.email
                )
            }
            is LoginUIEvent.PasswordChanged -> {
                loginUIState.value = loginUIState.value.copy(
                    password = event.password
                )
            }
            is LoginUIEvent.LoginButtonClicked -> {
                login()
            }
        }
        validateDataWithRules()
    }

    private fun validateDataWithRules() {
        Log.d(TAG, "Inside_validateDataWithRules")
        Log.d(TAG, "loginUIState.value.email=" + loginUIState.value.email)
        val emailResult = Validator.validateEmail(
            email = loginUIState.value.email
        )
        Log.d(TAG, "loginUIState.value.password=" + loginUIState.value.password)
        val passwordResult = Validator.validatePassword(
            password = loginUIState.value.password
        )
        Log.d(TAG, "emailResult = $emailResult")
        Log.d(TAG, "passwordResult = $passwordResult")

        loginUIState.value = loginUIState.value.copy(
            emailError = emailResult.status,
            passwordError = passwordResult.status
        )

        allValidationsPassed.value = emailResult.status && passwordResult.status
    }

    private fun login() {
        loginInProgress.value = true

        val email = loginUIState.value.email
        val password = loginUIState.value.password
        FirebaseAuth.getInstance()
            .signInWithEmailAndPassword(email, password)
            .addOnCompleteListener {
                Log.d(TAG, "Inside_OnCompleteListener")
                Log.d(TAG, "isSuccessful = ${it.isSuccessful}")

                if(it.isSuccessful){
                    loginInProgress.value = false
                    PostOfficeAppRouter.navigateTo(Screen.HomeScreen)
                }
            }
            .addOnFailureListener {
                loginInProgress.value = false
                Log.d(TAG, "Inside_OnFailureListener")
                Log.d(TAG, "Exception = ${it.message}")
                Log.d(TAG, "Exception = ${it.localizedMessage}")
            }
    }
}