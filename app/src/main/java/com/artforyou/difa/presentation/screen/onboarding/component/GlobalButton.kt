package com.artforyou.difa.presentation.screen.onboarding.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.artforyou.difa.ui.theme.activeTextBlue
import com.artforyou.difa.ui.theme.blueLight

@Composable
fun OnBoardingTextButton(
    title: String,
    modifier: Modifier = Modifier,
    moveTo: () -> Unit
) {
    TextButton(
        colors = ButtonDefaults.buttonColors(containerColor = blueLight),
        shape = MaterialTheme.shapes.small,
        elevation = ButtonDefaults.elevatedButtonElevation(defaultElevation = 0.dp),
        modifier = modifier
            .padding(bottom = 20.dp)
            .fillMaxWidth()
            .height(60.dp)
            .padding(start = 25.dp, end = 35.dp),
        onClick = moveTo
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.labelMedium.copy(
                fontWeight = FontWeight.Bold
            ),
            color = activeTextBlue,
            textAlign = TextAlign.Start,
        )
    }
}