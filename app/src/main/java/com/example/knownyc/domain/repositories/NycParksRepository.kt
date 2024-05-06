package com.example.knownyc.domain.repositories

import com.example.knownyc.commons.AppError
import com.example.knownyc.commons.Either
import com.example.knownyc.data.models.NycParkResponse
import com.example.knownyc.domain.models.NycPark

interface NycParksRepository {
    suspend fun getParks() : Either<AppError, List<NycParkResponse>>
}