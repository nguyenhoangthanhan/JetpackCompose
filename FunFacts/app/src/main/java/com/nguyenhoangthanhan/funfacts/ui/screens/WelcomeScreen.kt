package com.nguyenhoangthanhan.funfacts.ui.screens

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nguyenhoangthanhan.funfacts.ui.TextComponent
import com.nguyenhoangthanhan.funfacts.ui.TextWithShadow
import com.nguyenhoangthanhan.funfacts.ui.TopBar

@Composable
fun WelcomeScreen(username: String?, animalSelected: String?) {
    val TAG = "WelcomeScreen_TAG"
    Log.d(TAG, "username = $username")
    Log.d(TAG, "animalSelected = $animalSelected")
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(18.dp)
        ) {
            TopBar(value = "Welcome $username \uD83D\uDE0D")

            TextComponent(
                textValue = "Thank you! for sharing your data",
                textSize = 24.sp
            )

            Spacer(modifier = Modifier.size(60.dp))

            val finalText = if (animalSelected == "Cat")
                "You are a Cat lover \uD83D\uDC36"
            else "You are a Dog lover \uD83D\uDC36"

            TextWithShadow(value = finalText)
        }
    }
}

@Preview
@Composable
fun WelcomeScreenPreview() {
    WelcomeScreen("username", "animalSelected")
}