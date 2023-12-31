package com.nguyenhoangthanhan.learnjetpackcompose.navigation

import androidx.activity.ComponentActivity
import androidx.activity.OnBackPressedCallback
import androidx.activity.OnBackPressedDispatcherOwner
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.platform.LocalLifecycleOwner

private val LocalBackPressedDispatcher =
    staticCompositionLocalOf<OnBackPressedDispatcherOwner?> { null }

private class ComposableBackNavigationHandler(enabled: Boolean) : OnBackPressedCallback(enabled){

    lateinit var onBackPressed: () -> Unit
    override fun handleOnBackPressed() {
        onBackPressed()
    }
}

@Composable
internal fun ComposableHandler(
    enabled: Boolean = true,
    onBackPressed: () -> Unit
){
    val dispatcher = (LocalBackPressedDispatcher.current ?: return).onBackPressedDispatcher

    val handler = remember {
        ComposableBackNavigationHandler(enabled)
    }
    
    DisposableEffect(key1 = dispatcher, effect = {
        dispatcher.addCallback(handler)
        onDispose { handler.remove() }
    })
    
    LaunchedEffect(key1 = enabled, block = {
        handler.isEnabled = enabled
        handler.onBackPressed = onBackPressed
    })
}

@Composable
internal fun SystemBackButtonHandler(onBackPressed: () -> Unit){
    CompositionLocalProvider (
        values = arrayOf(LocalBackPressedDispatcher provides LocalLifecycleOwner.current as ComponentActivity),
        content = {
            ComposableHandler {
                onBackPressed()
            }
        }
    )
}