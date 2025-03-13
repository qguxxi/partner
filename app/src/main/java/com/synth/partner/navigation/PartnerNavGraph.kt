package com.synth.partner.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.synth.partner.presentation.screens.LocalePermissionScreen
import com.synth.partner.presentation.screens.LocationScreen
import com.synth.partner.presentation.screens.SignInScreen
import com.synth.partner.presentation.screens.WelcomeScreen
import com.synth.partner.presentation.viewmodel.AuthViewModel

@RequiresApi(Build.VERSION_CODES.Q)
@Composable
fun PartnerNavGraph(navController: NavHostController, viewModel: AuthViewModel = hiltViewModel()) {


    NavHost(
        navController = navController,
        startDestination = if (viewModel.isLoggedIn()) Screen.Home.route else Screen.SignIn.route
    ) {

        composable(Screen.Welcome.route) {
            WelcomeScreen { navController.navigate(Screen.Locale.route) }
        }

        composable(Screen.SignIn.route) {
            SignInScreen(onLoginSuccess = { navController.navigate(Screen.Welcome.route) })
        }

        composable(Screen.Locale.route) {
            LocalePermissionScreen { navController.navigate(Screen.Home.route) }
        }

        composable(Screen.Home.route) {
            LocationScreen()
        }

    }
}