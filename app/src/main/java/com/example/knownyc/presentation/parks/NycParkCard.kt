package com.example.knownyc.presentation.parks

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.knownyc.R

//TODO: Project 2
@Composable
fun NycParkCard(
    painter: Painter,
    signname: String?,
    location: String?,
    waterfront: Boolean,
    contentDescription: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
) {

    val shape = RoundedCornerShape(8.dp)
    val height : Dp = 148.dp
    Card(
        elevation = CardDefaults.elevatedCardElevation(8.dp),
        shape = shape,
        modifier = modifier
            .padding(10.dp)
            .shadow(
                elevation = 6.dp,
                spotColor = MaterialTheme.colorScheme.surfaceTint
            )
            .requiredHeight(height)
            .clickable {
                onClick()
            }
    ) {
        Box(
            modifier = modifier
                .fillMaxSize()
                .padding(10.dp)

        ) {
            Image(
                painter = painter,
                contentDescription = contentDescription,
                contentScale = ContentScale.Crop,
                modifier = modifier
                    .fillMaxWidth(0.3f)
                    .align(Alignment.CenterStart)
                    .padding(20.dp)
            )
            Column(
                modifier = modifier
                    .fillMaxWidth(0.6f)
                    .align(Alignment.Center)
                    .padding(10.dp)
            ) {
                if (signname != null) {
                    Text(
                        text = signname,
                        textAlign = TextAlign.Center,
                        color = MaterialTheme.colorScheme.onBackground,
                        fontWeight = FontWeight.Bold,
                        fontSize = 15.sp,
                        modifier = modifier
                            .align(Alignment.CenterHorizontally)
                            .padding(6.dp)
                    )
                }
                if (location != null) {
                    Text(
                        text = location,
                        textAlign = TextAlign.Center,
                        color = MaterialTheme.colorScheme.onBackground,
                        fontWeight = FontWeight.Bold,
                        fontSize = 15.sp,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        modifier = modifier
                            .align(Alignment.CenterHorizontally)
                            .padding(6.dp)
                    )
                }
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth(0.1f)
                    .align(Alignment.TopEnd)
                    .padding(1.dp)
            ) {
                if (waterfront) {
                    Image(
                        painter = painterResource(id = R.drawable.waves_24px),
                        contentDescription = "Has waterfront",
                        colorFilter = ColorFilter.tint(Color.Blue)
                    )
                } else {
                    Spacer(modifier = Modifier)
                }
            }

        }
    }
}

@Preview
@Composable
fun NycParkCardPreview() {
    NycParkCard(
        painter = painterResource(id = R.drawable.nyc_parks_logo),
        signname = "Sunset Cove Park",
        location = "W. 19 Rd. bet Jamaica Bay and Cross Bay Blvd.",
        waterfront = true,
        contentDescription = "Sunset Cove Park"
    )
}