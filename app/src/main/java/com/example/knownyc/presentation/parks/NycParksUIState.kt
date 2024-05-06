package com.example.knownyc.presentation.parks

import com.example.knownyc.commons.AppError
import com.example.knownyc.data.models.NycParkResponse
import com.example.knownyc.domain.models.NycPark

data class NycParksUIState(
    val isLoading: Boolean = false,
    val parks: List<NycParkResponse> = emptyList(),
    val error: AppError? = null,
 )
