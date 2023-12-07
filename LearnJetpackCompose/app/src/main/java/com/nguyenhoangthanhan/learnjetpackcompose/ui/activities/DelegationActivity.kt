package com.nguyenhoangthanhan.learnjetpackcompose.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner
import com.nguyenhoangthanhan.learnjetpackcompose.R
import kotlin.reflect.KProperty

class DelegationActivity : AppCompatActivity(), AnalyticsLogger by AnalyticsLoggerImpl(),
    DeepLinkHandler by DeeplinkHandlerImpl() {

    private val obj by MyLazy {
        println("Hello world!")
        3
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ) {
                Text(modifier = Modifier.fillMaxSize(), text = "ABC")
            }
        }
//        registerLifecycleOwner(this)

//        println(obj)
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
//        handleDeepLink(this, intent)
    }
}

class MyLazy<out T : Any>(
    private val initialize: () -> T
) {
    private var value: T? = null

    operator fun getValue(thisRef: Any?, property: KProperty<*>): T {
        return if (value == null) {
            value = initialize()
            value!!
        } else {
            value!!
        }
    }
}

interface DeepLinkHandler {
    fun handleDeepLink(activity: ComponentActivity, intent: Intent?)
}

class DeeplinkHandlerImpl : DeepLinkHandler {
    override fun handleDeepLink(activity: ComponentActivity, intent: Intent?) {

    }

}

interface AnalyticsLogger {
    fun registerLifecycleOwner(owner: LifecycleOwner)
}

class AnalyticsLoggerImpl : AnalyticsLogger, LifecycleEventObserver {
    override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
        when (event) {
            Lifecycle.Event.ON_RESUME -> println("AnalyticsLoggerImpl: User opened the screen")
            Lifecycle.Event.ON_PAUSE -> println("AnalyticsLoggerImpl: User leaves the screen")
            else -> Unit
        }
    }

    override fun registerLifecycleOwner(owner: LifecycleOwner) {
        owner.lifecycle.addObserver(this)
    }

}