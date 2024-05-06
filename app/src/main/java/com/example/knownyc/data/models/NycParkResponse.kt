package com.example.knownyc.data.models

data class NycParkResponse(
    val borough: Char?,
    val signname: String?,
    val location: String?,
    val waterfront: Boolean = false,
    val url: String?,
)
