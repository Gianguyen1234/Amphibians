package com.example.callingapiexample.network

import com.example.callingapiexample.model.AmphibiansData
import retrofit2.http.GET

interface AmphibiansApiService {

    @GET("amphibians")
    suspend fun getPhotos(): List<AmphibiansData>

}




