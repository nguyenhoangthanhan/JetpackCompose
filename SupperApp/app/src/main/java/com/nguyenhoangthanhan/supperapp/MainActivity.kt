package com.nguyenhoangthanhan.supperapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.nguyenhoangthanhan.supperapp.application.SuperApp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SuperApp()
        }
    }
}

@Preview
@Composable
fun DefaultPreview() {
    SuperApp()
}