package dev.yingke.android.nationalparklocations.network

data class NationalPark(
    val id: String,
    val url: String,
    val fullName: String,
    val parkCode: String,
    val description: String,
    val latitude: String,   // to be parsed to float
    val longitude: String,  // to be parsed to float
    val latLong: String?,
    val activities: List<NationalParkActivity>,
    val topics: List<NationalParkTopics>,
    val states: String,
    val contacts: NationalParkContact,
    val entranceFees: List<NationalParkEntranceFee>,
    val entrancePasses: List<NationalParkEntrancePass>?,
    val fees: List<String>,
    val directionsInfo: String,
    val directionsUrl: String,
    val operatingHours: List<NationalParkOperatingHours>,
    val addresses: List<NationalParkAddress>,
    val images: List<NationalParkImage>,
    val weatherInfo: String,
    val name: String,
    val designation: String,
)
