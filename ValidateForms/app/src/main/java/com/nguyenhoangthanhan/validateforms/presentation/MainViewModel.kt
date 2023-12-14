package com.nguyenhoangthanhan.validateforms.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.nguyenhoangthanhan.validateforms.domain.use_case.ValidateEmail
import com.nguyenhoangthanhan.validateforms.domain.use_case.ValidatePassword
import com.nguyenhoangthanhan.validateforms.domain.use_case.ValidateRepeatedPassword
import com.nguyenhoangthanhan.validateforms.domain.use_case.ValidateTerms

class MainViewModel(
    private val validateEmail: ValidateEmail = ValidateEmail(),
    private val validatePassword: ValidatePassword = ValidatePassword(),
    private val validateRepeatedPassword: ValidateRepeatedPassword = ValidateRepeatedPassword(),
    private val validateTerms: ValidateTerms = ValidateTerms()
): ViewModel() {

    val state by mutableStateOf(RegistrationFormState())
}