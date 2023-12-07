package com.nguyenhoangthanhan.learnjetpackcompose.ui.screens

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.activity.OnBackPressedCallback
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
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner
import com.nguyenhoangthanhan.learnjetpackcompose.navigation.LearnJetpackComposeRouter
import com.nguyenhoangthanhan.learnjetpackcompose.navigation.Screen
import com.nguyenhoangthanhan.learnjetpackcompose.navigation.SystemBackButtonHandler
import com.nguyenhoangthanhan.learnjetpackcompose.ui.activities.DelegationActivity

@Composable
fun DelegationScreen(activity: Activity){
    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){

        Button(
            onClick = {
                activity.applicationContext.startActivity(
                    Intent(activity, DelegationActivity::class.java).apply {
                        flags = Intent.FLAG_ACTIVITY_SINGLE_TOP
                    }
                )
            }
        ) {
            Text(text = "Open Delegation Activity")
        }

    }

    SystemBackButtonHandler {
        LearnJetpackComposeRouter.navigateTo(Screen.HomeScreen)
    }
}