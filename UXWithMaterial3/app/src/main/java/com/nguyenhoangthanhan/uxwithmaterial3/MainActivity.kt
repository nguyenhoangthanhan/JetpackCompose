package com.nguyenhoangthanhan.uxwithmaterial3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.nguyenhoangthanhan.uxwithmaterial3.application.Material3App
import com.nguyenhoangthanhan.uxwithmaterial3.ui.theme.UXWithMaterial3Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            UXWithMaterial3Theme {
                Material3App(this)
            }
        }
    }
}
