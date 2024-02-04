package com.nguyenhoangthanhan.canvas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.inset
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.graphics.drawscope.scale
import androidx.compose.ui.graphics.drawscope.translate
import androidx.compose.ui.graphics.drawscope.withTransform
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nguyenhoangthanhan.canvas.ui.theme.Blue1
import com.nguyenhoangthanhan.canvas.ui.theme.CanvasTheme
import com.nguyenhoangthanhan.canvas.ui.theme.Green1
import com.nguyenhoangthanhan.canvas.ui.theme.Purple40
import com.nguyenhoangthanhan.canvas.ui.theme.PurpleDark

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            MyCanvas()

//            CanvasDemo2()

//            CanvasScale()

//            CanvasTranslate()

//            CanvasRotate()

//            CanvasInset()

//            CanvasMultipleTransformations()

//            CanvasStockChart()


        }
    }
}

@Preview
@Composable
fun PreviewCanvasDemo() {
    CanvasStockChart()
}

@Composable
fun MyCanvas() {
    Canvas(
        modifier = Modifier
            .padding(20.dp)
            .fillMaxSize(),
        onDraw = {
            drawRect(
                color = Color.Black,
                size = size
            )
            drawRect(
                color = Color.Red,
                topLeft = Offset(100f, 100f),
                size = Size(100f, 100f),
                style = Stroke(
                    width = 3.dp.toPx()
                )
            )
            drawCircle(
                brush = Brush.radialGradient(
                    colors = listOf(Color.Red, Color.Yellow),
                    center = center,
                    radius = 100f
                ),
                radius = 100f
            )
            drawArc(
                color = Color.Green,
                startAngle = 0f,
                sweepAngle = 270f,
                useCenter = false,
                topLeft = Offset(100f, 500f),
                size = Size(200f, 200f),
                style = Stroke(
                    width = 3.dp.toPx()
                )
            )
            drawOval(
                color = Color.Magenta,
                topLeft = Offset(500f, 100f),
                size = Size(200f, 300f)
            )
            drawLine(
                color = Color.Cyan,
                start = Offset(300f, 700f),
                end = Offset(700f, 700f),
                strokeWidth = 5.dp.toPx()
            )
        }
    )
}

@Composable
fun CanvasDemo2() {
    Canvas(
        modifier = Modifier.fillMaxSize(),
        onDraw = {
            drawCircle(
                Color.Magenta,
                center = Offset(
                    20.dp.toPx(),
                    100.dp.toPx()
                ),
                radius = 60.dp.toPx()
            )
        }
    )
}

@Composable
fun CanvasScale() {
    Canvas(
        modifier = Modifier.fillMaxSize(),
        onDraw = {
            scale(
                scaleX = 5f,
                scaleY = 7.5f
            ) {
                drawCircle(Color.Blue, radius = 20.dp.toPx())
            }
        }
    )
}

@Composable
fun CanvasTranslate() {
    Canvas(
        modifier = Modifier.fillMaxSize(),
        onDraw = {
            translate(left = -100f, top = -300f) {
                drawCircle(Color.Blue, radius = 200.dp.toPx())
            }
        }
    )
}

@Composable
fun CanvasRotate() {
    Canvas(
        modifier = Modifier.fillMaxSize(),
        onDraw = {
            rotate(
                degrees = 45F
            ) {
                drawRect(
                    color = Color.Gray,
                    topLeft = Offset(
                        x = size.width / 3F,
                        y = size.height / 3F
                    ),
                    size = size / 3f
                )
            }
        }
    )
}

@Composable
fun CanvasInset() {
    Canvas(
        modifier = Modifier.fillMaxSize(),
        onDraw = {
            val quadrantSize = size / 2f
            inset(
                horizontal = 50f,
                vertical = 30f
            ) {
                drawRect(
                    color = Color.Green,
                    size = quadrantSize
                )
            }
        }
    )
}

@Composable
fun CanvasMultipleTransformations() {
    Canvas(
        modifier = Modifier.fillMaxSize(),
        onDraw = {
            withTransform(
                {
                    translate(left = size.width / 2f)
                    rotate(degrees = 45f)
                }
            ) {
                drawRect(
                    color = Color.Gray,
                    topLeft = Offset(
                        x = size.width / 3F,
                        y = size.height / 3F
                    ),
                    size = size / 3f
                )
            }
        }
    )
}

@Composable
fun CanvasStockChart() {
    Box(
        modifier = Modifier
            .background(PurpleDark)
            .fillMaxSize()
    ) {

    }
}