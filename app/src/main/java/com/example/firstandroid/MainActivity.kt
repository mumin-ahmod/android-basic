package com.example.firstandroid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.firstandroid.ui.theme.FirstAndroidTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FirstAndroidTheme {

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
//                        GreetingImage(message = stringResource(R.string.hello_text), from = stringResource(
//                            R.string.signature
//                        ));

                    ComposeTutorial();

                }
            }
        }
    }
}


@Composable
fun GreetingText(message: String, from: String, modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.padding(8.dp)
    ) {
        Text(
            text = message,
            fontSize = 100.sp,
            lineHeight = 116.sp,
            textAlign = TextAlign.Center
        )
        Text(
            text = from,
            fontSize = 36.sp,
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.CenterHorizontally)

        )
    }

}

@Composable
fun GreetingImage(message: String, from: String, modifier: Modifier = Modifier) {
    val img = painterResource(R.drawable.bday)

    Box(modifier= Modifier.fillMaxSize()) {
        Image(
            painter = img,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier= Modifier.fillMaxSize(),
            alpha = 0.5F
        )

        GreetingText(
            message = message,
            from = from,
            modifier = Modifier
                .fillMaxSize()
        )
    }
}

@Composable
fun ComposeTutorial(modifier: Modifier = Modifier) {
    val img = painterResource(R.drawable.bg_compose_background)
    Column(

    ) {

        Image(
            painter = img,
            contentDescription = null
        )

        Text(
            text = "Jetpack Compose tutorial",
            fontSize = 24.sp,
            modifier = Modifier.padding(all = 16.dp)
        )

        Text(
            text = "Jetpack Compose is a modern toolkit for building native Android UI. Compose simplifies and accelerates UI development on Android with less code, powerful tools, and intuitive Kotlin APIs.",
            fontSize = 16.sp,
            modifier = Modifier.padding(all = 16.dp),
            textAlign = TextAlign.Justify
        )

        Text(
            text = "In this tutorial, you build a simple UI component with declarative functions. You call Compose functions to say what elements you want and the Compose compiler does the rest. Compose is built around Composable functions. These functions let you define your app\\'s UI programmatically because they let you describe how it should look and provide data dependencies, rather than focus on the process of the UI\\'s construction, such as initializing an element and then attaching it to a parent. To create a Composable function, you add the @Composable annotation to the function name.",
            fontSize = 16.sp,
            modifier = Modifier.padding(all = 16.dp),
            textAlign = TextAlign.Justify
        )
    }

}




@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FirstAndroidTheme {

    }
}