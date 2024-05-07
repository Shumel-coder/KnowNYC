package com.example.knownyc.presentation.parks

import android.nfc.Tag
import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.knownyc.R
import com.example.knownyc.util.AppProviderModule_Companion_NycOpenDataApiServiceProviderFactory.nycOpenDataApiServiceProvider

@Composable
fun NycParkCard(
    signname: String?,
    location: String?,
    waterfront: Boolean,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
) {


    val shape = RoundedCornerShape(8.dp)
    val height : Dp = 148.dp
    Card(
        elevation = CardDefaults.elevatedCardElevation(8.dp),
        shape = shape,
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFdce7c8),
        ),
        modifier = modifier
            .padding(10.dp)
            .shadow(
                elevation = 6.dp,
                spotColor = Color(0xFFdce7c8)
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
                .border(BorderStroke(2.dp, Color(0xFF4c662b)))
        ) {
            Image(
                painter = painterResource(id = R.drawable.nyc_parks_logo),
                contentDescription = stringResource(id = R.string.parks_logo),
                contentScale = ContentScale.Crop,
                modifier = modifier
                    .fillMaxWidth(0.3f)
                    .align(Alignment.CenterStart)
                    .padding(20.dp)
            )
            Row(horizontalArrangement = Arrangement.SpaceBetween,
                modifier = modifier
                    .fillMaxWidth(0.65f)
                    .align(Alignment.Center)
            ) {
                Spacer(modifier = modifier
                    .padding(10.dp)
                )
                Column(
                    modifier = modifier
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
                            fontSize = 15.sp,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            modifier = modifier
                                .align(Alignment.CenterHorizontally)
                                .padding(6.dp)
                        )
                    }
                }

            }
            Column(
                modifier = Modifier
                    .fillMaxWidth(0.05f)
                    .padding(2.dp)
                    .align(Alignment.TopEnd)
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
        signname = "Sunset Cove Park",
        location = "W. 19 Rd. bet Jamaica Bay and Cross Bay Blvd.",
        waterfront = true,
    )
}