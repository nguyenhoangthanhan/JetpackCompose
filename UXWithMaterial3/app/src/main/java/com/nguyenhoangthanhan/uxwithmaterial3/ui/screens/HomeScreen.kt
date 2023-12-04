package com.nguyenhoangthanhan.uxwithmaterial3.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.nguyenhoangthanhan.uxwithmaterial3.navigation.MaterialAppRouter
import com.nguyenhoangthanhan.uxwithmaterial3.navigation.Screen

@Composable
fun HomeScreen(){
    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){

        Button(
            onClick = {
                MaterialAppRouter.navigateTo(Screen.ButtonScreen)
            }
        ) {
            Text(text = "Open Button Screen")
        }

        Spacer(modifier = Modifier.size(16.dp))

        Button(
            onClick = {
                MaterialAppRouter.navigateTo(Screen.TextFieldsScreen)
            }
        ) {
            Text(text = "Open TextFields Screen")
        }

    }
}