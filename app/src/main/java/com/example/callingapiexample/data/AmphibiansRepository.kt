package com.example.callingapiexample.data

import com.example.callingapiexample.model.AmphibiansData
import com.example.callingapiexample.network.AmphibiansApiService


interface AmphibiansRepository {

    suspend fun getAmphibians(): List<AmphibiansData>
}

class NetworkAmphibiansRepository(private val amphibiansApiService: AmphibiansApiService): AmphibiansRepository {
    override suspend fun getAmphibians(): List<AmphibiansData> = amphibiansApiService.getPhotos()

}