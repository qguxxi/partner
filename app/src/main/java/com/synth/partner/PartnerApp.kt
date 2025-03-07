package com.synth.partner

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.synth.partner.navigation.PartnerNavGraph

@Composable
fun PartnerApp(modifier: Modifier = Modifier) {
    PartnerNavGraph(rememberNavController())
}