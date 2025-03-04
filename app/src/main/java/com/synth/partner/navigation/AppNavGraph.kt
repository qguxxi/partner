package com.synth.partner.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.synth.partner.presentation.ui.screens.HomeScreen
import com.synth.partner.presentation.ui.screens.SignInScreen
import com.synth.partner.presentation.ui.screens.WelcomeScreen

@Composable
fun AppNavGraph() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = Screen.SignIn.route) {
        composable(Screen.SignIn.route) {
            SignInScreen(onLoginSuccess = { navController.navigate(Screen.Home.route) })
        }

        composable(Screen.Welcome.route) {
            WelcomeScreen()
        }

        composable(Screen.Home.route) {
            HomeScreen()
        }

    }
}