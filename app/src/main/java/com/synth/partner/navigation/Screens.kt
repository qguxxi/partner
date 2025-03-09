package com.synth.partner.navigation

sealed class Screen(val route: String) {
    data object SignIn: Screen("signIn")
    data object Welcome: Screen("welcome")
    data object Home: Screen("home")
    data object Locale: Screen("locale")

}