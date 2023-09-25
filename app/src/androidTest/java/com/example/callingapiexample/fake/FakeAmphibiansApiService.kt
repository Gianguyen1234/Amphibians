package com.example.callingapiexample.fake

import com.example.callingapiexample.model.AmphibiansData
import com.example.callingapiexample.network.AmphibiansApiService

class FakeAmphibiansApiService: AmphibiansApiService {
    override suspend fun getPhotos(): List<AmphibiansData> {
        return FakeDataSource.fakeDataList
    }
}