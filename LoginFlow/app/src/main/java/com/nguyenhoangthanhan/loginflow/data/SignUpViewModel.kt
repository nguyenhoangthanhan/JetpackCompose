package com.nguyenhoangthanhan.loginflow.data

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuth.AuthStateListener
import com.nguyenhoangthanhan.loginflow.data.rules.Validator
import com.nguyenhoangthanhan.loginflow.navigation.PostOfficeAppRouter
import com.nguyenhoangthanhan.loginflow.navigation.Screen

class SignUpViewModel : ViewModel() {

    private val TAG = "SignUpViewModel_TAG"

    var registrationUIState = mutableStateOf(RegistrationUIState())

    var allValidationsPassed = mutableStateOf(false)

    var signUpInProgress = mutableStateOf(false)

    fun onEvent(event: SignUpUIEvent) {
        validateDataWithRules()
        when (event) {
            is SignUpUIEvent.FirstNameChanged -> {
                registrationUIState.value = registrationUIState.value.copy(
                    firstName = event.firstName
                )
                printState()
            }

            is SignUpUIEvent.LastNameChanged -> {
                registrationUIState.value = registrationUIState.value.copy(
                    lastName = event.lastName
                )
                printState()
            }

            is SignUpUIEvent.EmailChanged -> {
                registrationUIState.value = registrationUIState.value.copy(
                    email = event.email
                )
                printState()
            }

            is SignUpUIEvent.PasswordChanged -> {
                registrationUIState.value = registrationUIState.value.copy(
                    password = event.password
                )
                printState()
            }

            is SignUpUIEvent.PrivacyPolicyCheckBoxClicked -> {
                registrationUIState.value = registrationUIState.value.copy(
                    privacyPolicyAccepted = event.status
                )
            }

            is SignUpUIEvent.RegisterButtonClicked -> {
                signUp()
            }
        }
        validateDataWithRules()
    }

    private fun signUp() {
        Log.d(TAG, "Inside_signUp")
        printState()

        createUserInFirebase(
            email = registrationUIState.value.email,
            password = registrationUIState.value.password
        )
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

        val privacyPolicyResult = Validator.validatePrivacyPolicyAcceptance(
            statusValue = registrationUIState.value.privacyPolicyAccepted
        )
        Log.d(TAG, "firstName = $fNameResult")
        Log.d(TAG, "lastNameResult = $lastNameResult")
        Log.d(TAG, "emailResult = $emailResult")
        Log.d(TAG, "passwordResult = $passwordResult")
        Log.d(TAG, "privacyPolicyResult = $privacyPolicyResult")

        registrationUIState.value = registrationUIState.value.copy(
            firstNameError = fNameResult.status,
            lastNameError = lastNameResult.status,
            emailError = emailResult.status,
            passwordError = passwordResult.status,
            privacyPolicyAccepted = privacyPolicyResult.status
        )

        allValidationsPassed.value = fNameResult.status && lastNameResult.status &&
                emailResult.status && passwordResult.status && privacyPolicyResult.status
    }

    private fun printState(){
        Log.d(TAG, "Inside_printState")
        Log.d(TAG, registrationUIState.value.toString())
    }

    private fun createUserInFirebase(email: String, password: String){

        signUpInProgress.value = true

        FirebaseAuth.getInstance()
            .createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener {
                Log.d(TAG, "Inside_OnCompleteListener")
                Log.d(TAG, "isSuccessful = ${it.isSuccessful}")

                signUpInProgress.value = false
                if(it.isSuccessful){
                    PostOfficeAppRouter.navigateTo(Screen.HomeScreen)
                }
            }
            .addOnFailureListener {
                signUpInProgress.value = false
                Log.d(TAG, "Inside_OnFailureListener")
                Log.d(TAG, "Exception = ${it.message}")
                Log.d(TAG, "Exception = ${it.localizedMessage}")
            }
    }

    fun logout(){
        val firebaseAuth = FirebaseAuth.getInstance()
        firebaseAuth.signOut()

        val authStateListener = AuthStateListener{
            if (it.currentUser == null){
                Log.d(TAG, "Inside sign out success")
                PostOfficeAppRouter.navigateTo(Screen.LoginScreen)
            }else{
                Log.d(TAG, "Inside sign out is not complete")
            }
        }

        firebaseAuth.addAuthStateListener(authStateListener)
    }
}