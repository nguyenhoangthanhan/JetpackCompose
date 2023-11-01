package com.nguyenhoangthanhan.loginflow.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
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
import com.nguyenhoangthanhan.loginflow.data.LoginViewModel
import com.nguyenhoangthanhan.loginflow.navigation.PostOfficeAppRouter
import com.nguyenhoangthanhan.loginflow.navigation.Screen
import androidx.lifecycle.viewmodel.compose.viewModel
import com.nguyenhoangthanhan.loginflow.data.UIEvent

@Composable
fun SignUpScreen(loinViewModel: LoginViewModel = viewModel()) {
    Surface (
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(28.dp)
    ){
        Column (
            modifier = Modifier.fillMaxSize()
        ){
            NormalTextComponent(value = stringResource(id = R.string.hello))
            HeadingTextComponent(value = stringResource(id = R.string.create_account))

            Spacer(modifier = Modifier.height(20.dp))
            MyTextFieldComponent(
                labelValue = stringResource(id = R.string.first_name),
                painterResource(id = R.drawable.icon_person_outline),
                onTextSelected = {
                    loinViewModel.onEvent(UIEvent.FirstNameChanged(it))
                }
            )
            MyTextFieldComponent(
                labelValue = stringResource(id = R.string.last_name),
                painterResource = painterResource(id = R.drawable.icon_person_outline),
                onTextSelected = {
                    loinViewModel.onEvent(UIEvent.LastNameChanged(it))
                }
            )
            MyTextFieldComponent(
                labelValue = stringResource(id = R.string.email),
                painterResource = painterResource(id = R.drawable.icon_mail_outline),
                onTextSelected = {
                    loinViewModel.onEvent(UIEvent.EmailChanged(it))
                }
            )
            MyPasswordTextFieldComponent(
                labelValue = stringResource(id = R.string.password),
                painterResource = painterResource(id = R.drawable.icon_password),
                onTextSelected = {
                    loinViewModel.onEvent(UIEvent.PasswordChanged(it))
                }
            )
            CheckboxComponent(
                value = stringResource(id = R.string.terms_and_conditions),
                onTextSelected = {
                    PostOfficeAppRouter.navigateTo(Screen.TermsAndConditionsScreen)
                }
            )
            Spacer(modifier = Modifier.height(40.dp))
            ButtonComponent(value = stringResource(id = R.string.register))
            Spacer(modifier = Modifier.height(20.dp))
            DividerTextComponent()
            ClickableLoginTextComponent(tryingToLogin = true, onTextSelected = {
                PostOfficeAppRouter.navigateTo(Screen.LoginScreen)
            })
        }
    }
}

@Preview
@Composable
fun DefaultPreviewOfSignUpScreen(){
    SignUpScreen()
}