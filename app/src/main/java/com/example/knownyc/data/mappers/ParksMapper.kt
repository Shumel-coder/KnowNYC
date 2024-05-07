package com.example.knownyc.data.mappers

import com.example.knownyc.data.local.provider.AssetsProvider
import com.example.knownyc.data.models.NycParkResponse
import com.example.knownyc.data.remote.repositories.NycOpenDataApiService
import com.example.knownyc.domain.models.NycPark
import org.json.JSONObject

suspend fun parksMapper(
    jsonObj : JSONObject,
    nycOpenDataApiService: NycOpenDataApiService,
) : List<NycParkResponse> {

    val jsonArray = jsonObj.getJSONArray("parks")

    val parks = mutableListOf<NycParkResponse>()

    for(i in 0 until jsonArray.length()) {
        val obj = jsonArray.getJSONObject(i)
        val park = NycParkResponse(
            borough = obj.getString("borough").first(),
            location = obj.getString("location"),
            signname = obj.getString("name"),
            waterfront = obj.getBoolean("waterfront"),
            url = obj.getString("url"),
        )
        parks.add(park)
    }

    return parks
}