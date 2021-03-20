package thevoid.whichbinds.composecodelab

import androidx.activity.OnBackPressedDispatcher
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import thevoid.whichbinds.composecodelab.codelab03.TodoViewModel
import thevoid.whichbinds.composecodelab.utils.LocalBackDispatcher

@Composable
fun MyApp(backDispatcher: OnBackPressedDispatcher, viewModel: TodoViewModel) {
    CompositionLocalProvider(LocalBackDispatcher provides backDispatcher) {
        NavGraph(viewModel = viewModel)
    }
}