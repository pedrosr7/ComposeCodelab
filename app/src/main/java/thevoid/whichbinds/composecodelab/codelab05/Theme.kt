package thevoid.whichbinds.composecodelab.codelab05

import androidx.compose.material.MaterialTheme
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

@Composable
fun AnimationCodelabTheme(content: @Composable () -> Unit) {
    val colors = lightColors(
        primary = Purple500,
        primaryVariant = Purple700,
        secondary = Teal200
    )
    MaterialTheme(
        colors = colors,
        content = content
    )
}
