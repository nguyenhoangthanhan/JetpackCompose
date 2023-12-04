package com.nguyenhoangthanhan.uxwithmaterial3.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.MonitorWeight
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import com.nguyenhoangthanhan.uxwithmaterial3.navigation.MaterialAppRouter
import com.nguyenhoangthanhan.uxwithmaterial3.navigation.Screen
import com.nguyenhoangthanhan.uxwithmaterial3.navigation.SystemBackButtonHandler

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextFieldsScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var filledText by remember {
            mutableStateOf("")
        }
        TextField(
            value = filledText,
            onValueChange = {
                filledText = it
            },
            textStyle = LocalTextStyle.current.copy(
                textAlign = TextAlign.Right
            ),
            placeholder = {
                Text(text = "Weight")
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Outlined.MonitorWeight,
                    contentDescription = "Weight"
                )
            },
            supportingText = {
                Text(text = "*Required")
            },
            isError = false,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Decimal,
                imeAction = ImeAction.Next
            ),
            keyboardActions = KeyboardActions(
                onNext = {
                    println("Hello world!")
                }
            )

        )

        var outlinedText by remember {
            mutableStateOf("")
        }
        OutlinedTextField(
            value = outlinedText,
            onValueChange = {
                filledText = it
            },
            textStyle = LocalTextStyle.current.copy(
                textAlign = TextAlign.Right
            ),
            placeholder = {
                Text(text = "Weight")
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Outlined.MonitorWeight,
                    contentDescription = "Weight"
                )
            },
            supportingText = {
                Text(text = "*Required")
            },
            isError = false,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Decimal,
                imeAction = ImeAction.Next
            ),
            keyboardActions = KeyboardActions(
                onNext = {
                    println("Hello world!")
                }
            )

        )
    }

    SystemBackButtonHandler {
        MaterialAppRouter.navigateTo(Screen.HomeScreen)
    }
}