package com.synth.partner.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.synth.partner.R


@Composable
fun WelcomeScreen(onContinueClick: () -> Unit = {}) {
    Box(
        contentAlignment = Alignment.BottomCenter
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Image(
                painter = painterResource(
                    R.drawable.background_1
                ),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
            WelcomeCard("manh", Modifier.align(Alignment.Center))
        }

    }
}

@Composable
fun WelcomeCard(nameUser: String, modifier: Modifier = Modifier) {
    Box {
        Card(
            shape = RoundedCornerShape(10.dp),
            colors = CardColors(
                contentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                disabledContentColor = MaterialTheme.colorScheme.primary,
                disabledContainerColor = MaterialTheme.colorScheme.onPrimary
            ),
            modifier = modifier
                .width(300.dp)
                .height(140.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(48.dp),
                verticalArrangement = Arrangement.Center,
            ) {
                Text(
                    text = "Xin chào, $nameUser",
                    style = MaterialTheme.typography.labelMedium
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Chào mừng bạn đến với Partner",
                    style = MaterialTheme.typography.labelMedium
                )
            }
        }
        Image(
            painter = painterResource(R.drawable.lock),
            contentDescription = null,
            modifier = Modifier.align(
                Alignment.TopEnd
            )
        )
    }
}

@Preview
@Composable
fun CardSectionPreview() {
    WelcomeScreen()
}