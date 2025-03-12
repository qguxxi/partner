package com.synth.partner.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
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
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.synth.partner.R
import com.synth.partner.presentation.components.ContinueButton


@Composable
fun WelcomeScreen(onContinueClick: () -> Unit) {
    Box(
        contentAlignment = Alignment.BottomCenter,
        modifier = Modifier
            .navigationBarsPadding()
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
        ContinueButton(onContinueClick,"Tiếp tục", Modifier.padding(bottom = 36.dp))
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
                .width(320.dp)
                .height(140.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
            ) {
                Column {
                    Text(
                        text = stringResource(R.string.hello) + " " + nameUser,
                        style = MaterialTheme.typography.labelLarge.copy(fontSize = 16.sp)
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = stringResource(R.string.welcome),
                        style = MaterialTheme.typography.labelLarge.copy(fontSize = 16.sp),
                        modifier = Modifier.alpha(0.5f)
                    )
                }
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
    WelcomeScreen({})
}