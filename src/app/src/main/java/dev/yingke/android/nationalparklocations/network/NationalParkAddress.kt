package dev.yingke.android.nationalparklocations.network

data class NationalParkAddress(
    val postalCode: String,
    val city: String,
    val stateCode: String,
    val line1: String,
    val line2: String,
    val line3: String,
    val type: String,
)
