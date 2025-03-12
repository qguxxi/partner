package com.synth.partner.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.synth.partner.R

@Composable
fun LocaleSection() {
    Column(
        verticalArrangement = Arrangement.spacedBy(0.dp), // Không có khoảng cách
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            stringResource(R.string.allow_location_label),
            style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold)
        )
        Text(
            stringResource(R.string.allow_location),
            style = MaterialTheme.typography.titleMedium.copy(
                fontSize = 14.sp,
                textAlign = TextAlign.Center
            ),
            modifier = Modifier.alpha(0.5f)
        )
    }
}