package com.example.knownyc.data.remote.repositories

import com.example.knownyc.data.models.NycParkResponse
import com.example.knownyc.domain.models.NycPark
import retrofit2.http.GET
import retrofit2.http.Query

interface NycOpenDataApiService {

    @GET("enfh-gkve.json")
    suspend fun getNycParks(
        @Query("borough") borough: String,
        @Query("retired") retired: Boolean = false,
    ): List<NycParkResponse>

}