package com.synth.partner

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.synth.partner.navigation.AppNavGraph

@Composable
fun PartnerApp() {
    AppNavGraph(navController = rememberNavController())
}