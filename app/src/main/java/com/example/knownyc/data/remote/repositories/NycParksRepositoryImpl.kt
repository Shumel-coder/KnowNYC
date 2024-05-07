package com.example.knownyc.data.remote.repositories

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresExtension
import com.example.knownyc.commons.AppError
import com.example.knownyc.commons.Either
import com.example.knownyc.commons.TAG
import com.example.knownyc.data.local.provider.AssetsProvider
import com.example.knownyc.data.mappers.boroughsMapper
import com.example.knownyc.data.mappers.parksMapper
import com.example.knownyc.data.mappers.toError
import com.example.knownyc.data.models.NycParkResponse
import com.example.knownyc.domain.models.Borough
import com.example.knownyc.domain.models.NycPark
import com.example.knownyc.domain.repositories.BoroughsRepository
import com.example.knownyc.domain.repositories.NycParksRepository
import com.example.knownyc.presentation.boroughs.BoroughsScreen
import com.example.knownyc.util.AppConstants
import com.example.knownyc.util.AppProviderModule.Companion.nycOpenDataApiServiceProvider
import org.json.JSONObject
import javax.inject.Inject
import javax.sql.DataSource

class NycParksRepositoryImpl @Inject constructor(
    private val nycOpenDataApiService: NycOpenDataApiService,
) : NycParksRepository {


    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    override suspend fun getParks(): Either<AppError, List<NycParkResponse>> {
        Log.d(TAG, "assets provider loading parks from JSON file")
        val data = nycOpenDataApiService.getNycParks()
        Log.d(TAG, "${data.toString()}")
        return try {
            Either.Data(
                nycOpenDataApiService.getNycParks()
            )
        } catch ( e : Exception) {
            Either.Error(
                e.toError()
            )
        }
    }
}