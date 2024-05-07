package com.example.knownyc.presentation.parks

import android.content.Context
import android.util.Log
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.knownyc.commons.TAG
import com.example.knownyc.presentation.ui.util.LoadingDialog



@Composable
fun NycParksScreen(
    context: Context,
    viewModel: NycParksViewModel,
    onParkClicked: (String) -> Unit,
    boroughCode: String,
    modifier: Modifier = Modifier,
) {

    viewModel.getParks(borough = boroughCode)
    val state by viewModel.state.collectAsStateWithLifecycle()

    LoadingDialog(isLoading = state.isLoading)
    LazyColumn(
        modifier = modifier
    ) {
        items(state.parks) {park ->
            NycParkCard(
                signname = park.signname,
                location = park.location,
                waterfront = park.waterfront,
            ) {
                //navigate to selected Park
                Log.d(TAG, "clicked: ${park.signname}, ${park.url}")
                onParkClicked(park.url!!)
            }
        }
    }
}