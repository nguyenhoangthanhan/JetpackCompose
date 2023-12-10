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
import kotlin.properties.Delegates
import kotlin.properties.ReadWriteProperty
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

//        val bird = Bird()
//        val chicken = Chicken()

//        bird.makeSound()
//        chicken.makeSound()
//        println(chicken.name)

//        chicken.officialName = "Putin Pro"
//        println(chicken.officialName)

//        bird.age = 20
//        bird.age = 25

//        bird.weight = 1.0
//        println("DelegationActivity_TAG: Weight: ${bird.weight}")
//        bird.weight = 2.5
//        println("DelegationActivity_TAG: Weight: ${bird.weight}")

        val bird = Bird(
            mapOf(
                "region" to "Europe",
                "lifespan" to 2
            )
        )

        println(
            """
            DelegationActivity_TAG: Lifespan: ${bird.lifespan} years
            DelegationActivity_TAG: Region: ${bird.region}
        """.trimIndent()
        )
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

interface Animal {
    val name: String
    val canFly: Boolean
    fun makeSound(): String
    fun move(direction: String)
}

class Bird(
    val birdDetails: Map<String, Any>
) : Animal {
    override val name: String
        get() = "DelegationActivity_TAG: Bird"

    @Deprecated("Use 'airborne' in stead", ReplaceWith("airborne"))
    override val canFly: Boolean by this::airborne

    val airborne: Boolean = true

    val canSwim: Boolean by lazy(LazyThreadSafetyMode.PUBLICATION) {
        false
    }

    val region: String by birdDetails
    val lifespan: Int by birdDetails

    var age: Int by Delegates.observable(0) { property: KProperty<*>, oldValue: Int, newValue: Int ->
        println(
            """
            DelegationActivity_TAG: ${property.name}
            DelegationActivity_TAG: Old: $oldValue
            DelegationActivity_TAG: New: $newValue
        """.trimIndent()
        )
    }

    var weight: Double by Delegates.vetoable(1.2) { property: KProperty<*>, oldValue: Double, newValue: Double ->
        println(
            """
            DelegationActivity_TAG: ${property.name}
            DelegationActivity_TAG: Old: $oldValue
            DelegationActivity_TAG: New: $newValue
        """.trimIndent()
        )
        oldValue < newValue
    }

    override fun makeSound(): String {
        println("DelegationActivity_TAG: This bird crows")
        return "DelegationActivity_TAG: Crows"
    }

    override fun move(direction: String) {
        println("DelegationActivity_TAG: The bird is flying towards the $direction")
    }
}

var birdAge: Int = 10

class BirdMeasure(val weight: Double = 1.1)

class Chicken(private var measure: BirdMeasure = BirdMeasure()) : Animal by Bird(mapOf()) {

    override val name: String by birdNameDelegate()

    var officialName: String by BirdName()

    var age: Int by ::birdAge

    val weight: Double by measure::weight

    override fun makeSound(): String {
        println("DelegationActivity_TAG: The Chicken is  crowing")
        return "DelegationActivity_TAG: crows"
    }

    override fun toString(): String {
        return """
            This is a chicken1
        """.trimIndent()
    }
}

class BirdName {
    operator fun getValue(classRef: Any?, property: KProperty<*>): String {
        return "DelegationActivity_TAG: Bird: $classRef"
    }

    operator fun setValue(classRef: Any?, property: KProperty<*>, value: String) {
        println("DelegationActivity_TAG: The $value property was delegated to $classRef")
    }
}

fun birdNameDelegate(name: String = ""): ReadWriteProperty<Any?, String> {
    return object : ReadWriteProperty<Any?, String>{
        var currentName = name
        override fun getValue(thisRef: Any?, property: KProperty<*>): String {
            return "Bird: $currentName"
        }

        override fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
            currentName = value
        }

    }
}
