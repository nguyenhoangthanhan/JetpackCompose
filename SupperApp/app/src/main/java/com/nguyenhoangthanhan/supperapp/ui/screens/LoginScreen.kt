package com.nguyenhoangthanhan.supperapp.ui.screens

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
import androidx.lifecycle.viewmodel.compose.viewModel
import com.nguyenhoangthanhan.supperapp.R
import com.nguyenhoangthanhan.supperapp.navigation.SuperAppRouter
import com.nguyenhoangthanhan.supperapp.navigation.Screen
import com.nguyenhoangthanhan.supperapp.navigation.SystemBackButtonHandler
import com.nguyenhoangthanhan.supperapp.ui.components.ButtonComponent
import com.nguyenhoangthanhan.supperapp.ui.components.ClickableLoginTextComponent
import com.nguyenhoangthanhan.supperapp.ui.components.DividerTextComponent
import com.nguyenhoangthanhan.supperapp.ui.components.HeadingTextComponent
import com.nguyenhoangthanhan.supperapp.ui.components.MyPasswordTextFieldComponent
import com.nguyenhoangthanhan.supperapp.ui.components.MyTextFieldComponent
import com.nguyenhoangthanhan.supperapp.ui.components.NormalTextComponent
import com.nguyenhoangthanhan.supperapp.ui.components.UnderLinedTextComponent
import com.nguyenhoangthanhan.supperapp.ui.uievents.LoginUIEvent
import com.nguyenhoangthanhan.supperapp.ui.viewmodels.LoginViewModel

@Composable
fun LoginScreen(loginViewModel: LoginViewModel = viewModel()) {

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(28.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                NormalTextComponent(value = stringResource(id = R.string.login))
                HeadingTextComponent(value = stringResource(id = R.string.welcome_back))
                Spacer(modifier = Modifier.height(20.dp))
                MyTextFieldComponent(
                    labelValue = stringResource(id = R.string.email),
                    painterResource = painterResource(id = R.drawable.icon_mail_outline),
                    onTextSelected = {
                        loginViewModel.onEvent(LoginUIEvent.EmailChanged(it))
                    },
                    errorStatus = loginViewModel.loginUIState.value.emailError
                )
                MyPasswordTextFieldComponent(
                    labelValue = stringResource(id = R.string.password),
                    painterResource = painterResource(id = R.drawable.icon_password),
                    onTextSelected = {
                        loginViewModel.onEvent(LoginUIEvent.PasswordChanged(it))
                    },
                    errorStatus = loginViewModel.loginUIState.value.passwordError
                )
                Spacer(modifier = Modifier.height(40.dp))
                UnderLinedTextComponent(value = stringResource(id = R.string.forgot_password))
                Spacer(modifier = Modifier.height(40.dp))
                ButtonComponent(
                    value = stringResource(id = R.string.login),
                    onButtonClicked = {
                        loginViewModel.onEvent(LoginUIEvent.LoginButtonClicked)
                    },
                    isEnabled = loginViewModel.allValidationsPassed.value
                )
                Spacer(modifier = Modifier.height(20.dp))
                DividerTextComponent()
                ClickableLoginTextComponent(tryingToLogin = false, onTextSelected = {
                    SuperAppRouter.navigateTo(Screen.SignUpScreen)
                })
            }
        }

        if (loginViewModel.loginInProgress.value) {
            CircularProgressIndicator()
        }
    }

    SystemBackButtonHandler {
        SuperAppRouter.navigateTo(Screen.SignUpScreen)
    }
}

@Preview
@Composable
fun DefaultPreviewOfLoginScreen() {
    LoginScreen()
}