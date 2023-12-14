package com.nguyenhoangthanhan.validateforms.presentation

sealed class RegistrationFormEvent {
    data class EmailChanged(val email: String) : RegistrationFormEvent()
    data class PasswordChanged(val password: String) : RegistrationFormEvent()
    data class RepeatedPasswordChanged(val repeatedPassword: String) : RegistrationFormEvent()
    data class AcceptTerms(val isAccepted: String) : RegistrationFormEvent()

    object Submit : RegistrationFormEvent()
}