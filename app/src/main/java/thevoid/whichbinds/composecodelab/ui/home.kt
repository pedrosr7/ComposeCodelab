package thevoid.whichbinds.composecodelab.ui

import androidx.annotation.StringRes
import androidx.compose.animation.Crossfade
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.SpringSpec
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.os.ConfigurationCompat
import dev.chrisbanes.accompanist.insets.navigationBarsPadding
import thevoid.whichbinds.composecodelab.R
import thevoid.whichbinds.composecodelab.ui.components.*
import thevoid.whichbinds.composecodelab.ui.theme.VVTheme

private enum class HomeSections(
    @StringRes val title: Int,
    val icon: ImageVector
) {
    Codelab01(R.string.home_codelab01, Icons.Outlined.Home),
    Codelab02(R.string.home_codelab02, Icons.Outlined.Search),
    Codelab03(R.string.home_codelab03, Icons.Outlined.ShoppingCart),
    Codelab04(R.string.home_codelab04, Icons.Outlined.AccountCircle),
    Codelab05(R.string.home_codelab05, Icons.Outlined.AccountCircle)
}

@Composable
fun Home(onSnackSelected: (Long) -> Unit) {
    val (currentSection, setCurrentSection) = rememberSaveable {
        mutableStateOf(HomeSections.Codelab01)
    }
    val navItems = HomeSections.values().toList()
    VVScaffold(
        bottomBar = {
            BottomNav(
                currentSection = currentSection,
                onSectionSelected = setCurrentSection,
                items = navItems
            )
        }
    ) { innerPadding ->
        val modifier = Modifier.padding(innerPadding)
        Crossfade(currentSection) { section ->
            when (section) {
/* HomeSections.Codelab01 -> CodeLab01()
 HomeSections.Codelab02 -> CodeLab02()
 HomeSections.Codelab03 -> Cart(onSnackSelected, modifier)
 HomeSections.Codelab04 -> Profile(modifier)
 HomeSections.Codelab05 -> Profile(modifier)*/
}
}
}
}

@Composable
private fun BottomNav(
currentSection: HomeSections,
onSectionSelected: (HomeSections) -> Unit,
items: List<HomeSections>,
color: Color = VVTheme.colors.iconPrimary,
contentColor: Color = VVTheme.colors.iconInteractive
) {
VVSurface(
color = color,
contentColor = contentColor
) {
val springSpec = remember {
SpringSpec<Float>(
 // Determined experimentally
 stiffness = 800f,
 dampingRatio = 0.8f
)
}
VVBottomNavLayout(
selectedIndex = currentSection.ordinal,
itemCount = items.size,
indicator = { VVBottomNavIndicator() },
animSpec = springSpec,
modifier = Modifier.navigationBarsPadding(left = false, right = false)
) {
items.forEach { section ->
 val selected = section == currentSection
 val tint by animateColorAsState(
     if (selected) {
         VVTheme.colors.iconInteractive
     } else {
         VVTheme.colors.iconInteractiveInactive
     }
 )

 VVBottomNavigationItem(
     icon = {
         Icon(
             imageVector = section.icon,
             tint = tint,
             contentDescription = null
         )
     },
     text = {
         Text(
             text = stringResource(section.title).toUpperCase(
                 ConfigurationCompat.getLocales(
                     LocalConfiguration.current
                 ).get(0)
             ),
             color = tint,
             style = MaterialTheme.typography.button,
             maxLines = 1
         )
     },
     selected = selected,
     onSelected = { onSectionSelected(section) },
     animSpec = springSpec,
     modifier = BottomNavigationItemPadding
         .clip(BottomNavIndicatorShape)
 )
}
}
}
}


@Preview
@Composable
private fun JsetsnackBottomNavPreview() {
VVTheme {
BottomNav(
currentSection = HomeSections.Codelab01,
onSectionSelected = { },
items = HomeSections.values().toList()
)
}
}