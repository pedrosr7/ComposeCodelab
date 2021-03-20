package thevoid.whichbinds.composecodelab

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import androidx.navigation.compose.*
import thevoid.whichbinds.composecodelab.MainDestinations.CODELAB_01_ROUTE
import thevoid.whichbinds.composecodelab.MainDestinations.CODELAB_02_ROUTE
import thevoid.whichbinds.composecodelab.MainDestinations.CODELAB_03_ROUTE
import thevoid.whichbinds.composecodelab.MainDestinations.CODELAB_04_ROUTE
import thevoid.whichbinds.composecodelab.MainDestinations.CODELAB_05_ROUTE
import thevoid.whichbinds.composecodelab.codelab01.CodeLab01
import thevoid.whichbinds.composecodelab.codelab02.CodeLab02
import thevoid.whichbinds.composecodelab.codelab03.TodoViewModel
import thevoid.whichbinds.composecodelab.codelab03.feature.CodeLab03
import thevoid.whichbinds.composecodelab.codelab04.CodeLab04
import thevoid.whichbinds.composecodelab.codelab05.home.Home


/**
 * Destinations used in the ([OwlApp]).
 */
object MainDestinations {
    const val CODELAB_01_ROUTE = "codelab01"
    const val CODELAB_02_ROUTE = "codelab02"
    const val CODELAB_03_ROUTE = "codelab03"
    const val CODELAB_04_ROUTE = "codelab04"
    const val CODELAB_05_ROUTE = "codelab05"

}

sealed class Screen(val route: String, val resourceId: String) {
    object Codelab01 : Screen(CODELAB_01_ROUTE, CODELAB_01_ROUTE)
    object Codelab02 : Screen(CODELAB_02_ROUTE, CODELAB_02_ROUTE)
    object Codelab03 : Screen(CODELAB_03_ROUTE, CODELAB_03_ROUTE)
    object Codelab04 : Screen(CODELAB_04_ROUTE, CODELAB_04_ROUTE)
    object Codelab05 : Screen(CODELAB_05_ROUTE, CODELAB_05_ROUTE)
}

val items = listOf(
    Screen.Codelab01,
    Screen.Codelab02,
    Screen.Codelab03,
    Screen.Codelab04,
    Screen.Codelab05,
)
@Composable
fun NavGraph(startDestination: String = CODELAB_01_ROUTE, viewModel: TodoViewModel) {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            BottomNavigation {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute = navBackStackEntry?.arguments?.getString(CODELAB_01_ROUTE)
                items.forEach { screen ->
                    BottomNavigationItem(
                        icon = { Icons.Filled.Favorite },
                        label = { Text(screen.resourceId) },
                        selected = currentRoute == screen.route,
                        onClick = {
                            navController.navigate(screen.route) {
                                // Pop up to the start destination of the graph to
                                // avoid building up a large stack of destinations
                                // on the back stack as users select items
                                popUpTo = navController.graph.startDestination
                                // Avoid multiple copies of the same destination when
                                // reselecting the same item
                                launchSingleTop = true
                            }
                        }
                    )
                }
            }
        }
    ) {
        NavHost(navController, startDestination = Screen.Codelab01.route) {
            composable(Screen.Codelab01.route) { CodeLab01(navController) }
            composable(Screen.Codelab02.route) { CodeLab02(navController) }
            composable(Screen.Codelab03.route) { CodeLab03(viewModel) }
            composable(Screen.Codelab04.route) { CodeLab04() }
            composable(Screen.Codelab05.route) { Home() }

        }
    }

    /*val actions = remember(navController) { MainActions(navController) }
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(MainDestinations.CODELAB_01_ROUTE) {
            CodeLab01()
        }
        composable(MainDestinations.CODELAB_02_ROUTE) {
            CodeLab02()
        }
        composable(MainDestinations.CODELAB_03_ROUTE) {
            //Courses(selectCourse = actions.selectCourse)
        }
        composable(MainDestinations.CODELAB_04_ROUTE) {
            //Courses(selectCourse = actions.selectCourse)
        }
        composable(MainDestinations.CODELAB_05_ROUTE) {
            //Courses(selectCourse = actions.selectCourse)
        }
    }*/
}

/**
 * Models the navigation actions in the app.
 */
class MainActions(navController: NavHostController) {
    /*val selectCodelab01: () -> Unit = {
        navController.navigate(MainDestinations.CODELAB_02)
    }
    val selectCodelab02: () -> Unit = {
        navController.navigate(MainDestinations.CODELAB_03)
    }

    val selectCodelab03: () -> Unit = {
        navController.navigate(MainDestinations.CODELAB_03)
    }

    val selectCodelab04: () -> Unit = {
        navController.navigate(MainDestinations.CODELAB_04)
    }

    val selectCodelab05: () -> Unit = {
        navController.navigate(MainDestinations.CODELAB_05)
    }*/

    val upPress: () -> Unit = {
        navController.navigateUp()
    }
}