package thevoid.whichbinds.composecodelab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.core.view.WindowCompat
import thevoid.whichbinds.composecodelab.codelab03.TodoViewModel
import thevoid.whichbinds.composecodelab.utils.LocalSysUiController
import thevoid.whichbinds.composecodelab.utils.SystemUiController

class MainActivity : ComponentActivity() {

    private val todoViewModel by viewModels<TodoViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, true)

        setContent {
            val systemUiController = remember { SystemUiController(window) }
            CompositionLocalProvider(LocalSysUiController provides systemUiController) {
                MyApp(onBackPressedDispatcher, todoViewModel)
            }

        }
    }
}

