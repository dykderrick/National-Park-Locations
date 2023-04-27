package dev.yingke.android.nationalparklocations.`interface`

import dev.yingke.android.nationalparklocations.BuildConfig
import dev.yingke.android.nationalparklocations.network.NationalParksMetaInfo
import retrofit2.Response
import retrofit2.http.GET

interface NPSApi {
    @GET("parks?limit=469&api_key=" + BuildConfig.NPS_API_KEY)
    suspend fun getNationalParks() : Response<NationalParksMetaInfo>
}
