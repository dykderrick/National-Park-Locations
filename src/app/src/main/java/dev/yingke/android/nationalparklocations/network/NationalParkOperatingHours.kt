package dev.yingke.android.nationalparklocations.network

import com.google.gson.JsonObject
import java.util.Date

data class NationalParkOperatingHours(
    val exceptions: List<OperatingHoursException>,
    val description: String,
    val standardHours: StandardHours,
    val name: String,
)

data class OperatingHoursException(
    val exceptionHours: JsonObject,
    val startDate: Date,
    val name: String,
    val endDate: Date,
)

data class StandardHours(
    val monday: String,
    val tuesday: String,
    val wednesday: String,
    val thursday: String,
    val friday: String,
    val saturday: String,
    val sunday: String,
)
