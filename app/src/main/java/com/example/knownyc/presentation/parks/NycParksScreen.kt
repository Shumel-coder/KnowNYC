package com.example.knownyc.presentation.parks

import android.util.Log
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.knownyc.R
import com.example.knownyc.commons.TAG
import com.example.knownyc.presentation.ui.util.LoadingDialog


@Composable
fun NycParksScreen(
    modifier: Modifier = Modifier,
    onParkClicked: (String) -> Unit,
    boroughCode: String,
) {

    val viewModel: NycParksViewModel = hiltViewModel()
    val state by viewModel.state.collectAsStateWithLifecycle()

    LoadingDialog(isLoading = state.isLoading)
    LazyColumn(
        modifier = modifier
    ) {
        items(state.parks) {park ->
            NycParkCard(
                painter = painterResource(id = R.drawable.waves_24px),
                signname = park.signname,
                location = park.location,
                waterfront = park.waterfront,
                contentDescription = stringResource(id = R.string.parks_logo),
            ) {
                //navigate to selected Park
                Log.d(TAG, "clicked: ${park.signname}")
                onParkClicked(park.url!!)
            }
        }
    }
}