package com.dmw.composetutorial.status

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun WellnessScreen(
    modifier: Modifier = Modifier,
    wellnessViewModel: WellnessViewModel = viewModel()
) {

    Column(modifier = modifier) {
        StatefulCounter(modifier)
        val list = remember { wellnessViewModel.tasks }

        WellnessTasksList(
            modifier,
            list = list,
            onCheckedTask = { task, checked ->
                wellnessViewModel.changeTaskChecked(task, checked)
            },
            onClose = { task -> wellnessViewModel.remove(task) }
        )
    }
}
