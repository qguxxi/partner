package com.synth.partner.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.synth.partner.R



@Composable
fun PrivacyAndTerm(privacyOnClick : () -> Unit , termServiceOnClick : () -> Unit , modifier : Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically ,
            horizontalArrangement = Arrangement.Center ,
            modifier = Modifier.fillMaxWidth()
        ) {
            Spacer(modifier = Modifier.width(16.dp))
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally ,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
                .alpha(0.5f)
        ) {
            Text(
                text = stringResource(R.string.term) ,
                style = MaterialTheme.typography.labelSmall ,
                color = MaterialTheme.colorScheme.onSurface
            )
            Text(
                text = stringResource(R.string.policy) ,
                style = MaterialTheme.typography.labelSmall ,
                color = MaterialTheme.colorScheme.onSurface
            )
        }
        Row(
            horizontalArrangement = Arrangement.Absolute.SpaceEvenly ,
            verticalAlignment = Alignment.CenterVertically ,
            modifier = Modifier.fillMaxWidth()
        ) {
            TextButton(onClick = termServiceOnClick) {
                Text(
                    text = stringResource(id = R.string.term_main) ,
                    style = MaterialTheme.typography.labelMedium ,
                    color = MaterialTheme.colorScheme.onSurface
                )
            }
            TextButton(onClick = privacyOnClick) {
                Text(
                    text = stringResource(id = R.string.policy_main) ,
                    style = MaterialTheme.typography.labelMedium ,
                    color = MaterialTheme.colorScheme.onSurface
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun BottomBarSignInPreview() {
    PrivacyAndTerm(privacyOnClick = { /*TODO*/ } , termServiceOnClick = { /*TODO*/ })
}