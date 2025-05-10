package com.artforyou.difa.presentation.screen.home.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowRight
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.artforyou.difa.R
import com.artforyou.difa.ui.theme.PurpleLight
import com.artforyou.difa.ui.theme.RedLight
import com.artforyou.difa.ui.theme.activeTextBlue
import com.artforyou.difa.ui.theme.blueLight

@Composable
fun RightImageCard(
    modifier: Modifier = Modifier,
    title: String,
    description: String,
    imageRes: Int,
    onClick: () -> Unit,
) {
    Card(
        colors = CardDefaults.cardColors(containerColor = PurpleLight),
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 0.dp),
        shape = MaterialTheme.shapes.small,
        modifier = modifier
            .fillMaxWidth()
            .clickable { onClick() }
    ) {
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 10.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(10.dp),
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.bodySmall.copy(
                        fontWeight = FontWeight.Bold
                    ),
                    color = Color.Black,
                    modifier = Modifier.fillMaxWidth()
                )
                Text(
                    text = description,
                    style = MaterialTheme.typography.labelSmall,
                    color = Color.Black,
                    modifier = Modifier.fillMaxWidth()
                )
            }
            Image(
                painter = painterResource(id = imageRes),
                contentScale = ContentScale.Fit,
                contentDescription = null,
                modifier = Modifier.size(150.dp)
            )
        }
    }
}

@Composable
fun LeftImageCard(
    modifier: Modifier = Modifier,
    title: String,
    description: String,
    imageRes: Int,
    onClick: () -> Unit,
) {
    Card(
        colors = CardDefaults.cardColors(containerColor = RedLight),
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 0.dp),
        shape = MaterialTheme.shapes.small,
        modifier = modifier
            .fillMaxWidth()
            .clickable { onClick() }
    ) {
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 10.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(
                painter = painterResource(id = imageRes),
                contentDescription = null,
                contentScale = ContentScale.Fit,
                modifier = Modifier.size(150.dp)
            )
            Column(
                verticalArrangement = Arrangement.spacedBy(10.dp),
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.bodySmall.copy(
                        fontWeight = FontWeight.Bold
                    ),
                    color = Color.Black,
                    modifier = Modifier.fillMaxWidth()
                )
                Text(
                    text = description,
                    style = MaterialTheme.typography.labelSmall,
                    color = Color.Black,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}

@Composable
fun RecommendationSibiCard(
    modifier: Modifier = Modifier,
    image: Int,
    title: String,
    description: String,
    onClick: () -> Unit
) {
    Card(
        colors = CardDefaults.cardColors(containerColor = PurpleLight),
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 0.dp),
        shape = MaterialTheme.shapes.small,
        modifier = modifier
            .fillMaxWidth()
            .clickable { onClick() }
    ) {
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 10.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(
                painter = painterResource(id = image),
                contentDescription = null,
                modifier = Modifier
                    .clip(MaterialTheme.shapes.extraSmall)
                    .size(width = 90.dp, height = 70.dp),
            )
            Column(
                verticalArrangement = Arrangement.spacedBy(5.dp),
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.labelSmall.copy(
                        fontWeight = FontWeight.Bold
                    ),
                    color = Color.Black,
                    modifier = Modifier.fillMaxWidth()
                )
                Text(
                    text = description,
                    style = MaterialTheme.typography.labelSmall,
                    color = Color.Black,
                    modifier = Modifier.fillMaxWidth()
                )
            }
            Icon(
                imageVector = Icons.Default.ArrowRight,
                tint = Color.Black,
                contentDescription = ""
            )
        }
    }
}

@Composable
fun RecommendationSibiCard(
    modifier: Modifier = Modifier,
) {
    Card(
        colors = CardDefaults.cardColors(containerColor = PurpleLight),
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 0.dp),
        shape = MaterialTheme.shapes.small,
        modifier = modifier
            .fillMaxWidth()
    ) {
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 10.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_background),
                contentDescription = null,
                modifier = Modifier
                    .clip(MaterialTheme.shapes.extraSmall)
                    .size(width = 90.dp, height = 70.dp),
            )
            Column(
                verticalArrangement = Arrangement.spacedBy(5.dp),
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = "Recomendation Sibi",
                    style = MaterialTheme.typography.labelSmall.copy(
                        fontWeight = FontWeight.Bold
                    ),
                    color = Color.Black,
                    modifier = Modifier.fillMaxWidth()
                )
                Text(
                    text = "Description Sibi",
                    style = MaterialTheme.typography.labelSmall,
                    color = Color.Black,
                    modifier = Modifier.fillMaxWidth()
                )
            }
            Icon(
                imageVector = Icons.Default.ArrowRight,
                tint = Color.Black,
                contentDescription = ""
            )
        }
    }
}

@Composable
fun VerticalArticleCard(
    modifier: Modifier = Modifier,
    title: String,
    description: String,
    image: Int,
    onClick: () -> Unit
) {
    Card(
        colors = CardDefaults.cardColors(containerColor = blueLight),
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 0.dp),
        shape = MaterialTheme.shapes.small,
        modifier = modifier
            .fillMaxWidth()
            .clickable { onClick() }
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(5.dp),
        ) {
            Image(
                painter = painterResource(id = image),
                contentDescription = null,
                contentScale = ContentScale.Fit,
                modifier = Modifier.fillMaxWidth().height(140.dp).clip(
                    RoundedCornerShape(topEnd = 10.dp, topStart = 10.dp, bottomStart = 0.dp, bottomEnd = 0.dp)
                )
            )
            Text(
                text = title,
                style = MaterialTheme.typography.labelLarge,
                color = Color.Black,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.fillMaxWidth().padding(horizontal = 10.dp)
            )
            Text(
                text = description,
                style = MaterialTheme.typography.labelSmall,
                color = Color.Black,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.fillMaxWidth().height(100.dp).padding(horizontal = 10.dp)
            )
        }
    }
}

@Composable
fun VerticalArticleCard(
    modifier: Modifier = Modifier,
) {
    Card(
        colors = CardDefaults.cardColors(containerColor = blueLight),
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 0.dp),
        shape = MaterialTheme.shapes.small,
        modifier = modifier
            .fillMaxWidth()
            .clickable {  }
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(5.dp),
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_background),
                contentDescription = null,
                contentScale = ContentScale.Fit,
                modifier = Modifier.fillMaxWidth().height(140.dp).clip(
                    RoundedCornerShape(topEnd = 10.dp, topStart = 10.dp, bottomStart = 0.dp, bottomEnd = 0.dp)
                )
            )
            Text(
                text = "Article 1",
                style = MaterialTheme.typography.labelLarge,
                color = Color.Black,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.fillMaxWidth().padding(horizontal = 10.dp)
            )
            Text(
                text = "Descripsi Article",
                style = MaterialTheme.typography.labelSmall,
                color = Color.Black,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.fillMaxWidth().height(100.dp).padding(horizontal = 10.dp)
            )
        }
    }
}

@Composable
fun IconVerticalCard(
    modifier: Modifier = Modifier,
    color: Color,
    title: String,
    image: Int,
    onClick: () -> Unit
) {
    Card(
        colors = CardDefaults.cardColors(containerColor = color),
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 0.dp),
        shape = MaterialTheme.shapes.small,
        modifier = modifier
            .clickable { onClick() }
            .width(87.dp)
            .height(80.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = image),
                contentDescription = null,
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .size(42.dp)
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = title,
                style = MaterialTheme.typography.labelSmall,
                color = Color.Black,
                textAlign = TextAlign.Center,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
            Spacer(modifier = Modifier.height(10.dp))
        }
    }
}


@Preview
@Composable
fun IconVerticalCardPrev(){
    IconVerticalCard(
        title = "Bantuam",
        color = RedLight,
        image = R.drawable.mulai_komunikasi,
    ){

    }
}

@Preview
@Composable
private fun RightImageCardPrev() {
    RightImageCard(
        title = stringResource(R.string.text_about),
        description = stringResource(R.string.title_about_1),
        imageRes = R.drawable.baseline_arrow_left_24
    ) {

    }
}

@Preview
@Composable
private fun LeftImageCardPrev() {
    LeftImageCard(
        title = stringResource(R.string.text_about),
        description = stringResource(R.string.title_about_1),
        imageRes = R.drawable.baseline_arrow_left_24
    ) {

    }
}

@Preview
@Composable
private fun RecommendationSibiCardPrev() {
    RecommendationSibiCard(
        image = R.drawable.baseline_arrow_left_24,
        title = "Recomendation 1",
        description = "Recomendation 2",
    ){

    }
}

@Preview
@Composable
private fun VerticalArticleCardPrev() {
    VerticalArticleCard(
        image = R.drawable.baseline_arrow_left_24,
        title = "Recomendation 1",
        description = "Recomendation 2",
    ){

    }
}