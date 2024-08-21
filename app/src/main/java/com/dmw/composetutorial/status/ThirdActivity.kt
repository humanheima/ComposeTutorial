package com.dmw.composetutorial.status

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.dmw.composetutorial.ui.theme.ComposeTutorialTheme

/**
 * Created by p_dmweidu on 2024/8/20
 * Desc: Jetpack Compose 中的状态
 *
 * https://developer.android.com/codelabs/jetpack-compose-state
 */
class ThirdActivity : ComponentActivity() {

    companion object {

        fun launch(context: Context) {
            val starter = Intent(context, ThirdActivity::class.java)
            context.startActivity(starter)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTutorialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    WellnessScreen()
                }
            }
        }
    }
}