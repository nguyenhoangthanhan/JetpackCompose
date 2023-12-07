@file:OptIn(ExperimentalMaterial3Api::class)

package com.nguyenhoangthanhan.uxwithmaterial3.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.nguyenhoangthanhan.uxwithmaterial3.R
import com.nguyenhoangthanhan.uxwithmaterial3.navigation.MaterialAppRouter
import com.nguyenhoangthanhan.uxwithmaterial3.navigation.Screen
import com.nguyenhoangthanhan.uxwithmaterial3.navigation.SystemBackButtonHandler
import kotlinx.coroutines.launch

@Composable
fun BottomSheetsScreen() {
    val sheetState = rememberModalBottomSheetState()
    var isSheetOpen by rememberSaveable {
        mutableStateOf(false)
    }
    val scaffoldState = rememberBottomSheetScaffoldState()
    val scope = rememberCoroutineScope()

    BottomSheetScaffold(
        scaffoldState = scaffoldState,
        sheetContent = {
            Image(
                painter = painterResource(id = R.drawable.beautiful_universe),
                contentDescription = null
            )
        },
        sheetPeekHeight = 0.dp
    ) {

        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Button(
                onClick = {
                    scope.launch {
                        scaffoldState.bottomSheetState.expand()
                    }
                }
            ) {
                Text(text = "Open sheet")
            }
        }
    }

//    if (isSheetOpen) {
//        ModalBottomSheet(
//            sheetState = sheetState,
//            onDismissRequest = {
//                isSheetOpen = false
//            }
//        ) {
//            Image(
//                painter = painterResource(id = R.drawable.beautiful_universe),
//                contentDescription = null
//            )
//        }
//    }

    SystemBackButtonHandler {
        MaterialAppRouter.navigateTo(Screen.HomeScreen)
    }
}