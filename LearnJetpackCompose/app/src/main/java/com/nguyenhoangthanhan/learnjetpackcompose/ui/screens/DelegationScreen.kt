package com.nguyenhoangthanhan.learnjetpackcompose.ui.screens

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
import com.nguyenhoangthanhan.learnjetpackcompose.navigation.LearnJetpackComposeRouter
import com.nguyenhoangthanhan.learnjetpackcompose.navigation.Screen

@Composable
fun DelegationScreen(){
    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){

        Button(
            onClick = {
            }
        ) {
            Text(text = "DelegationScreen")
        }

    }
}