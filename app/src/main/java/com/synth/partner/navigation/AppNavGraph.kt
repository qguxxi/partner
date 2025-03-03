package com.synth.partner.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.synth.partner.presentation.ui.screen.SignInScreen
import com.synth.partner.presentation.ui.screen.WelcomeScreen

@Composable
fun AppNavGraph(navController : NavHostController) {
    NavHost(navController = navController, startDestination = Screen.SignIn.route) {

        composable(Screen.SignIn.route) {
            SignInScreen()
        }

        composable(Screen.Welcome.route) {
            WelcomeScreen()
        }

    }
}