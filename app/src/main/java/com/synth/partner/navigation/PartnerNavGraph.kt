package com.synth.partner.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.synth.partner.presentation.screens.HomeScreen
import com.synth.partner.presentation.screens.LocalePermissionScreen
import com.synth.partner.presentation.screens.SignInScreen
import com.synth.partner.presentation.screens.WelcomeScreen

@Composable
fun PartnerNavGraph(navController : NavHostController) {
    NavHost(navController = navController, startDestination = Screen.SignIn.route) {

        composable(Screen.SignIn.route) {
            SignInScreen { navController.navigate(Screen.Welcome.route) }
        }

        composable(Screen.Welcome.route) {
            WelcomeScreen { navController.navigate(Screen.Locale.route) }
        }
        composable(Screen.Locale.route) {
            LocalePermissionScreen()
        }

        composable(Screen.Home.route) {
            HomeScreen()
        }

    }
}