package com.dmw.composetutorial.status

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun WaterCounter(modifier: Modifier = Modifier) {

    Column(modifier = modifier.padding(16.dp)) {
        /**
         * 使用 by 关键字委托，我们可以间接读取 count 并将其设置为可变，
         * 而无需每次都显式引用 MutableState 的 value 属性。
         *
         */

        //定义了一个持续记忆的变量，名称为 count。
        //var count by remember { mutableIntStateOf(0) }
        var count by rememberSaveable { mutableIntStateOf(0) }

        if (count > 0) {
            Text(text = "You've had ${count} glasses.")
        }

        Button(onClick = { count++ }, enabled = count < 10) {
            Text(text = "Add one")
        }
    }


}

@Composable
fun StatefulCounter(modifier: Modifier = Modifier) {
    var count by rememberSaveable { mutableIntStateOf(0) }
    StatelessCounter(count, { count++ }, modifier)
}

@Composable
fun StatelessCounter(count: Int, onIncrement: () -> Unit, modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(16.dp)) {
        if (count > 0) {
            Text(text = "You've had $count glasses.")
        }
        Button(onClick = onIncrement, enabled = count < 10) {
            Text(text = "Add one")
        }
    }
}

