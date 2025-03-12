package com.synth.partner.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.synth.partner.presentation.screens.HomeScreen
import com.synth.partner.presentation.screens.LocalePermissionScreen
import com.synth.partner.presentation.screens.SignInScreen
import com.synth.partner.presentation.screens.WelcomeScreen
import com.synth.partner.presentation.viewmodel.AuthViewModel

@Composable
fun PartnerNavGraph(navController: NavHostController, viewModel: AuthViewModel = hiltViewModel()) {


    NavHost(navController = navController, startDestination = if (viewModel.isLoggedIn()) Screen.Home.route else Screen.SignIn.route) {
        composable(Screen.Welcome.route) {
            WelcomeScreen { navController.navigate(Screen.Locale.route) }
        }
        composable(Screen.SignIn.route) {
            SignInScreen { navController.navigate(Screen.Welcome.route) }
        }
        composable(Screen.Locale.route) {
            LocalePermissionScreen { navController.navigate(Screen.Home.route) }
        }

        composable(Screen.Home.route) {
            HomeScreen()
        }

    }
}