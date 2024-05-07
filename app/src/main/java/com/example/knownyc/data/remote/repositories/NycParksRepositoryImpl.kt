package com.example.knownyc.data.remote.repositories

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresExtension
import com.example.knownyc.commons.AppError
import com.example.knownyc.commons.Either
import com.example.knownyc.commons.TAG
import com.example.knownyc.data.mappers.toError
import com.example.knownyc.data.models.NycParkResponse
import com.example.knownyc.domain.repositories.NycParksRepository
import javax.inject.Inject

class NycParksRepositoryImpl @Inject constructor(
    private val nycOpenDataApiService: NycOpenDataApiService,
) : NycParksRepository {


    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    override suspend fun getParks(borough: String): Either<AppError, List<NycParkResponse>> {
        Log.d(TAG, "assets provider loading parks from JSON file")
        val data = nycOpenDataApiService.getNycParks(borough)
        Log.d(TAG, "${data.toString()}")
        return try {
            Either.Data(
                data
            )
        } catch ( e : Exception) {
            Either.Error(
                e.toError()
            )
        }
    }
}