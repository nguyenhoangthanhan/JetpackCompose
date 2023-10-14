package com.nguyenhoangthanhan.learnjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MainScreen()
        }
    }
}

@Composable
fun MainScreen(){
    Row(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()
        .background(Color.White)
    ){
//        TextComponent("Android", shadowColor = Color.Yellow)
//        TextComponent("Kotlin", shadowColor = Color.Cyan)

        EventNumbers()
    }
}

@Composable
fun TextComponent(s: String, shadowColor: Color) {

    val shadowOffset = Offset(x = 4f, y = 6f)

    Text(
        modifier = Modifier
            .width(80.dp)
            .height(80.dp)
            .padding(
                18.dp
            ),
        text = s,
        color = Color.Blue,
        fontWeight = FontWeight.Medium,
        style = TextStyle(
            fontSize = 24.sp,
            fontStyle = FontStyle.Normal,
            shadow = Shadow(shadowColor, shadowOffset, 2f)
        )
    )
}

@Composable
fun EventNumbers(){
    for (number in 2..10){
        if (number % 2 == 0){
            val color = Color(
                red = Random.nextInt(256),
                blue = Random.nextInt(256),
                green = Random.nextInt(256)
            )
            TextComponent(number.toString(), color)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview(){
    MainScreen()
}
