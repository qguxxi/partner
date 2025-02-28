package com.synth.partner.presentation.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.synth.partner.R

@Composable
fun GoogleButton(onGoogleClick:() -> Unit,modifier : Modifier = Modifier) {
    Button(
        onClick = onGoogleClick,
        shape = RoundedCornerShape(10.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.secondaryContainer,
            contentColor = MaterialTheme.colorScheme.onSecondaryContainer
        ),
        modifier = Modifier
            .width(276.dp)
            .height(52.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.google_icon_container) ,
                contentDescription = null ,
                tint = Color.Unspecified
            )
            Spacer(Modifier.width(dimensionResource(R.dimen.medium)))
            Text(
                stringResource(R.string.google),
                style = MaterialTheme.typography.titleSmall,
                color = Color(0xFF0E2892)
                )

        }
    }
}

@Preview
@Composable
private fun GoogleButtonPreview() {
    GoogleButton({})
}