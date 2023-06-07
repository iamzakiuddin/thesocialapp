package com.android.socialapp.network

import com.android.socialapp.models.Data
import retrofit2.Response
import retrofit2.http.GET

interface DataApi {

    @GET("staging/android/premium/channels-socials.json")
    suspend fun getUIData() : Response<Data>
}