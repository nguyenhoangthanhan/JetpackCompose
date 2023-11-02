package com.nguyenhoangthanhan.loginflow.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nguyenhoangthanhan.loginflow.R
import com.nguyenhoangthanhan.loginflow.components.ButtonComponent
import com.nguyenhoangthanhan.loginflow.components.CheckboxComponent
import com.nguyenhoangthanhan.loginflow.components.ClickableLoginTextComponent
import com.nguyenhoangthanhan.loginflow.components.DividerTextComponent
import com.nguyenhoangthanhan.loginflow.components.HeadingTextComponent
import com.nguyenhoangthanhan.loginflow.components.MyPasswordTextFieldComponent
import com.nguyenhoangthanhan.loginflow.components.MyTextFieldComponent
import com.nguyenhoangthanhan.loginflow.components.NormalTextComponent
import com.nguyenhoangthanhan.loginflow.data.SignUpViewModel
import com.nguyenhoangthanhan.loginflow.navigation.PostOfficeAppRouter
import com.nguyenhoangthanhan.loginflow.navigation.Screen
import androidx.lifecycle.viewmodel.compose.viewModel
import com.nguyenhoangthanhan.loginflow.data.SignUpUIEvent

@Composable
fun SignUpScreen(signUpViewModel: SignUpViewModel = viewModel()) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(28.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                NormalTextComponent(value = stringResource(id = R.string.hello))
                HeadingTextComponent(value = stringResource(id = R.string.create_account))

                Spacer(modifier = Modifier.height(20.dp))
                MyTextFieldComponent(
                    labelValue = stringResource(id = R.string.first_name),
                    painterResource(id = R.drawable.icon_person_outline),
                    onTextSelected = {
                        signUpViewModel.onEvent(SignUpUIEvent.FirstNameChanged(it))
                    },
                    errorStatus = signUpViewModel.registrationUIState.value.firstNameError
                )
                MyTextFieldComponent(
                    labelValue = stringResource(id = R.string.last_name),
                    painterResource = painterResource(id = R.drawable.icon_person_outline),
                    onTextSelected = {
                        signUpViewModel.onEvent(SignUpUIEvent.LastNameChanged(it))
                    },
                    errorStatus = signUpViewModel.registrationUIState.value.lastNameError
                )
                MyTextFieldComponent(
                    labelValue = stringResource(id = R.string.email),
                    painterResource = painterResource(id = R.drawable.icon_mail_outline),
                    onTextSelected = {
                        signUpViewModel.onEvent(SignUpUIEvent.EmailChanged(it))
                    },
                    errorStatus = signUpViewModel.registrationUIState.value.emailError
                )
                MyPasswordTextFieldComponent(
                    labelValue = stringResource(id = R.string.password),
                    painterResource = painterResource(id = R.drawable.icon_password),
                    onTextSelected = {
                        signUpViewModel.onEvent(SignUpUIEvent.PasswordChanged(it))
                    },
                    errorStatus = signUpViewModel.registrationUIState.value.passwordError
                )
                CheckboxComponent(
                    value = stringResource(id = R.string.terms_and_conditions),
                    onTextSelected = {
                        PostOfficeAppRouter.navigateTo(Screen.TermsAndConditionsScreen)
                    },
                    onCheckedChange = {
                        signUpViewModel.onEvent(SignUpUIEvent.PrivacyPolicyCheckBoxClicked(it))
                    }
                )
                Spacer(modifier = Modifier.height(40.dp))
                ButtonComponent(
                    value = stringResource(id = R.string.register),
                    onButtonClicked = {
                        signUpViewModel.onEvent(SignUpUIEvent.RegisterButtonClicked)
                    },
                    isEnabled = signUpViewModel.allValidationsPassed.value
                )
                Spacer(modifier = Modifier.height(20.dp))
                DividerTextComponent()
                ClickableLoginTextComponent(tryingToLogin = true, onTextSelected = {
                    PostOfficeAppRouter.navigateTo(Screen.LoginScreen)
                })
            }
        }

        if (signUpViewModel.signUpInProgress.value){
            CircularProgressIndicator()
        }
    }
}

@Preview
@Composable
fun DefaultPreviewOfSignUpScreen() {
    SignUpScreen()
}