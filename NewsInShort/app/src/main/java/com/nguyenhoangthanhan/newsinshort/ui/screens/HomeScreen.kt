package com.nguyenhoangthanhan.newsinshort.ui.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.nguyenhoangthanhan.newsinshort.ui.viewmodels.NewViewModel

@Composable
fun HomeScreen(
    newViewModel: NewViewModel = hiltViewModel()
) {
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {

    }
}

@Preview
@Composable
fun HomeScreenPreview(){
    HomeScreen()
}