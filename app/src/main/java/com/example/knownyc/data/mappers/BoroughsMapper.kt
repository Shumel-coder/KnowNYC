package com.example.knownyc.data.mappers


import com.example.knownyc.data.local.provider.AssetsProvider
import com.example.knownyc.domain.models.Borough
import org.json.JSONObject

suspend fun boroughsMapper(
    jsonObj : JSONObject,
    localAssetsProvider: AssetsProvider,
) : List<Borough> {

    val jsonArray = jsonObj.getJSONArray("boroughs")

    val boroughs = mutableListOf<Borough>()

    for(i in 0 until jsonArray.length()) {
        val obj = jsonArray.getJSONObject(i)
        val borough = Borough(
            boroCode = obj.getString("borough").first(),
            name = obj.getString("shortName"),
            longName = obj.getString("fullName"),
            image = localAssetsProvider.getDrawableResourceId(obj.getString("imageFilename")),
        )
        boroughs.add(borough)
    }

    return boroughs
}