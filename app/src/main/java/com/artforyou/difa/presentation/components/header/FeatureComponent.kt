package com.artforyou.difa.presentation.components.header

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.artforyou.difa.R
import com.artforyou.difa.ui.theme.PurpleMainColor
import com.artforyou.difa.ui.theme.activeTextBlue
import com.artforyou.difa.ui.theme.blueLight

@Composable
fun ComingSoonFeatureImage(
    onButtonClicked: () -> Unit,
    modifier: Modifier = Modifier
){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
    ) {
        Image(
            painter = painterResource(id = R.drawable.coming_soon),
            contentDescription = stringResource(R.string.img_onboarding),
            modifier = Modifier
                .fillMaxWidth()
                .height(350.dp)
                .padding(horizontal = 16.dp)
        )
        Text(
            text = stringResource(id = R.string.coming_soon_text),
            style = MaterialTheme.typography.bodySmall.copy(
                fontWeight = FontWeight.Bold
            ),
            color = Color.Black,
            textAlign = TextAlign.Start,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 25.dp, end = 35.dp)
        )
        Spacer(modifier = Modifier.height(24.dp))
        Text(
            text = stringResource(id = R.string.coming_soon_desc),
            style = MaterialTheme.typography.labelMedium.copy(
                fontWeight = FontWeight.Normal
            ),
            color = Color.Black,
            textAlign = TextAlign.Start,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 25.dp, end = 35.dp)
        )
        Spacer(modifier = Modifier.height(24.dp))
        TextButton(
            colors = ButtonDefaults.buttonColors(containerColor = PurpleMainColor),
            shape = MaterialTheme.shapes.small,
            elevation = ButtonDefaults.elevatedButtonElevation(defaultElevation = 0.dp),
            modifier = Modifier
                .padding(bottom = 20.dp)
                .fillMaxWidth()
                .height(60.dp)
                .padding(start = 25.dp, end = 35.dp),
            onClick = onButtonClicked
        ) {
            Text(
                text = "Kembali",
                style = MaterialTheme.typography.labelMedium.copy(
                    fontWeight = FontWeight.Bold
                ),
                color = Color.White,
                textAlign = TextAlign.Start,
            )
        }
    }
}
