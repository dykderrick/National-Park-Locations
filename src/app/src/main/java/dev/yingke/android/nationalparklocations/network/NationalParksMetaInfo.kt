package dev.yingke.android.nationalparklocations.network

data class NationalParksMetaInfo(
    val total: Int,
    val limit: Int,
    val start: Int,
    val data: List<NationalPark>,
)
