package it.fast4x.rilauncher

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandIn
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.animation.shrinkOut
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.lifecycle.Lifecycle
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import it.fast4x.rilauncher.enums.NavRoutes
import it.fast4x.rilauncher.enums.TransitionEffect
import it.fast4x.rilauncher.ui.home.AppsScreen
import it.fast4x.rilauncher.ui.home.CallsScreen
import it.fast4x.rilauncher.ui.home.HomeScreen
import it.fast4x.rilauncher.ui.home.MessagesScreen
import it.fast4x.rilauncher.ui.home.RemindersScreen
import it.fast4x.rilauncher.ui.home.SettingsScreen
import it.fast4x.rilauncher.ui.home.ShortcutsScreen
import it.fast4x.rilauncher.utils.rememberPreference
import it.fast4x.rilauncher.utils.transitionEffectKey


@OptIn(ExperimentalFoundationApi::class, ExperimentalAnimationApi::class,
    ExperimentalTextApi::class, ExperimentalComposeUiApi::class,
    ExperimentalMaterial3Api::class
)
@Composable
fun Navigation(
    navController: NavHostController,
) {
    val transitionEffect by rememberPreference(transitionEffectKey, TransitionEffect.Scale)

    NavHost(
        navController = navController,
        startDestination = NavRoutes.Home.name,
        enterTransition = {
            when (transitionEffect) {
                TransitionEffect.None -> EnterTransition.None
                TransitionEffect.Expand -> expandIn(animationSpec = tween(700, easing = LinearOutSlowInEasing), expandFrom = Alignment.TopStart)
                TransitionEffect.Fade -> fadeIn(animationSpec = tween(700))
                TransitionEffect.Scale -> scaleIn(animationSpec = tween(700))
                TransitionEffect.SlideVertical -> slideIntoContainer(AnimatedContentTransitionScope.SlideDirection.Up)
                TransitionEffect.SlideHorizontal -> slideIntoContainer(AnimatedContentTransitionScope.SlideDirection.Left)
            }
        },
        exitTransition = {
            when (transitionEffect) {
                TransitionEffect.None -> ExitTransition.None
                TransitionEffect.Expand -> shrinkOut(animationSpec = tween(700, easing = FastOutSlowInEasing),shrinkTowards = Alignment.TopStart)
                TransitionEffect.Fade -> fadeOut(animationSpec = tween(700))
                TransitionEffect.Scale -> scaleOut(animationSpec = tween(700))
                TransitionEffect.SlideVertical -> slideOutOfContainer(AnimatedContentTransitionScope.SlideDirection.Down)
                TransitionEffect.SlideHorizontal -> slideOutOfContainer(AnimatedContentTransitionScope.SlideDirection.Right)
            }
        },
        popEnterTransition = {
            when (transitionEffect) {
                TransitionEffect.None -> EnterTransition.None
                TransitionEffect.Expand -> expandIn(animationSpec = tween(700, easing = LinearOutSlowInEasing), expandFrom = Alignment.TopStart)
                TransitionEffect.Fade -> fadeIn(animationSpec = tween(700))
                TransitionEffect.Scale -> scaleIn(animationSpec = tween(700))
                TransitionEffect.SlideVertical -> slideIntoContainer(AnimatedContentTransitionScope.SlideDirection.Up)
                TransitionEffect.SlideHorizontal -> slideIntoContainer(AnimatedContentTransitionScope.SlideDirection.Left)
            }
        },
        popExitTransition = {
            when (transitionEffect) {
                TransitionEffect.None -> ExitTransition.None
                TransitionEffect.Expand -> shrinkOut(animationSpec = tween(700, easing = FastOutSlowInEasing),shrinkTowards = Alignment.TopStart)
                TransitionEffect.Fade -> fadeOut(animationSpec = tween(700))
                TransitionEffect.Scale -> scaleOut(animationSpec = tween(700))
                TransitionEffect.SlideVertical -> slideOutOfContainer(AnimatedContentTransitionScope.SlideDirection.Down)
                TransitionEffect.SlideHorizontal -> slideOutOfContainer(AnimatedContentTransitionScope.SlideDirection.Right)
            }
        }
    ) {

//        val navigateToItem =
//            { id: String -> navController.navigate("${NavRoutes.route.name}/$id") }
        val pop = {
            if (navController.currentBackStackEntry?.lifecycle?.currentState == Lifecycle.State.RESUMED) navController.popBackStack()
        }

        composable(route = NavRoutes.Home.name) {
            HomeScreen(
                navController = navController,

            )
        }
        composable(route = NavRoutes.Apps.name) {
            AppsScreen(
                navController = navController,
            )
        }
        composable(route = NavRoutes.Shortcuts.name) {
            ShortcutsScreen(
                navController = navController,
            )
        }
        composable(route = NavRoutes.Calls.name) {
            CallsScreen(
                navController = navController,
            )
        }
        composable(route = NavRoutes.Messages.name) {
            MessagesScreen(
                navController = navController,
            )
        }
        composable(route = NavRoutes.Reminders.name) {
            RemindersScreen(
                navController = navController,
            )
        }
        composable(route = NavRoutes.Settings.name) {
            SettingsScreen(
                navController = navController,
            )
        }


    }
}