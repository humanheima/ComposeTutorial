package com.dmw.composetutorial

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dmw.composetutorial.ui.theme.ComposeTutorialTheme

/**
 * Created by p_dmweidu on 2024/8/16
 * Desc:对应这个 codelab 中的内容
 * @link
 * https://developer.android.com/codelabs/jetpack-compose-basics?hl=zh-cn
 */
class SecondActivity : ComponentActivity() {


    companion object {

        fun launch(context: Context) {
            val starter = Intent(context, SecondActivity::class.java)
            context.startActivity(starter)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTutorialTheme {
                MyApp(modifier = Modifier.fillMaxSize())
            }
        }
    }
}


@Composable
private fun OnboardingScreen(
    onContinueClicked: () -> Unit,
    modifier: Modifier = Modifier
) {

    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,

        ) {
        Text(text = "Welcome to Jetpack Compose!")
        Button(modifier = modifier.padding(vertical = 24.dp), onClick = onContinueClicked) {
            Text(text = "Continue")
        }
    }
}

@Preview(showBackground = true, widthDp = 320, heightDp = 320)
@Composable
fun OnboardingPreview() {
    ComposeTutorialTheme {
        OnboardingScreen(
            onContinueClicked = { },
        )
    }
}


@Composable
fun MyApp(modifier: Modifier = Modifier) {
    var shouldShowOnboarding by remember { mutableStateOf(true) }
    Surface(modifier) {
        if (shouldShowOnboarding) {
            OnboardingScreen(
                onContinueClicked = { shouldShowOnboarding = false },
            )
        } else {
            Greetings()
        }
    }
}

@Preview
@Composable
fun MyAppPreview() {
    ComposeTutorialTheme {
        MyApp(Modifier.fillMaxSize())
    }
}

@Composable
private fun Greetings(
    modifier: Modifier = Modifier,
    name: List<String> = listOf("World", "Compose"),
) {
    Column(modifier = modifier.padding(vertical = 4.dp)) {
        name.forEach { name -> Greeting(name) }
    }
}

@Preview(showBackground = true, widthDp = 320)
@Composable
fun GreetingsPreview() {
    ComposeTutorialTheme {
        Greetings()
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {

    val expanded = remember {
        mutableStateOf(false)
    }

    val extraPadding = if (expanded.value) 48.dp else 0.dp

    Surface(
        color = MaterialTheme.colorScheme.primary,

        modifier = modifier.padding(vertical = 4.dp, horizontal = 8.dp)
    ) {
        Row(modifier = modifier.padding(24.dp)) {
            Column(
                modifier = modifier
                    .weight(1f)
                    .padding(bottom = extraPadding)
            ) {

                Text(
                    text = "Hello",
                )
                Text(
                    text = name,
                )
            }
            ElevatedButton(onClick = {
                expanded.value = !expanded.value
            }) {
                Text(text = if (expanded.value) "Show less" else "Show more")
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeTutorialTheme {
        MyApp()
    }
}

