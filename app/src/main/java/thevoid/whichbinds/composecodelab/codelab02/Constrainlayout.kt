package thevoid.whichbinds.composecodelab.codelab02

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import thevoid.whichbinds.composecodelab.ui.theme.VVTheme


@Composable
fun ConstraintLayoutContent() {
    /*ConstraintLayout {

        // Create references for the composables to constrain
        val (button, text) = createRefs()

        Button(
            onClick = { /* Do something */ },
            // Assign reference "button" to the Button composable
            // and constrain it to the top of the ConstraintLayout
            modifier = Modifier.constrainAs(button) {
                top.linkTo(parent.top, margin = 16.dp)
            }
        ) {
            Text("Button")
        }

        // Assign reference "text" to the Text composable
        // and constrain it to the bottom of the Button composable
        Text("Text", Modifier.constrainAs(text) {
            top.linkTo(button.bottom, margin = 16.dp)
        })
    }*/
}

@Preview
@Composable
fun ConstraintLayoutContentPreview() {
    VVTheme {
        ConstraintLayoutContent()
    }
}