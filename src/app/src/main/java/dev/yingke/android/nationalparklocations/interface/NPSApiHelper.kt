package dev.yingke.android.nationalparklocations.`interface`

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NPSApiHelper {
    private const val baseUrl = "https://developer.nps.gov/api/v1/"

    fun getInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}