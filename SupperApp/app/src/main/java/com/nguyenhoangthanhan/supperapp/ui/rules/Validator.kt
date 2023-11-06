package com.nguyenhoangthanhan.supperapp.ui.rules

object Validator {

    fun validateFirstName(firstName: String): ValidationResult {
        return ValidationResult(
            (firstName.isNotEmpty() && firstName.length >= 2)
        )
    }

    fun validateLastName(lastName: String): ValidationResult {
        return ValidationResult(
            (lastName.isNotEmpty() && lastName.length >= 2)
        )
    }

    fun validateEmail(email: String): ValidationResult {
        return ValidationResult(
            (email.isNotEmpty())
        )
    }

    fun validatePassword(password: String): ValidationResult {
        return ValidationResult(
            (password.isNotEmpty() && password.length >= 4)
        )
    }

    fun validatePrivacyPolicyAcceptance(statusValue: Boolean): ValidationResult {
        return ValidationResult(
            statusValue
        )
    }
}

data class ValidationResult(
    val status: Boolean = false
)