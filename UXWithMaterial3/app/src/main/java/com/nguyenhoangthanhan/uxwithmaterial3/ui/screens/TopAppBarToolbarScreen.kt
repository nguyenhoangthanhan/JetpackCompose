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
import com.nguyenhoangthanhan.uxwithmaterial3.navigation.SystemBackButtonHandler

@Composable
fun TopAppBarToolbarScreen(){
    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){

        Text(text = "Top App bar", modifier = Modifier.fillMaxSize())
    }

    SystemBackButtonHandler {
        MaterialAppRouter.navigateTo(Screen.HomeScreen)
    }
}