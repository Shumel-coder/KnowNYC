package com.example.knownyc.data.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class NycParkResponse(
    val borough: Char? = null,
    val signname: String? = null,
    val location: String? = null,
    @SerialName("url") val url: String? = null,
    val waterfront: Boolean = false,
)
