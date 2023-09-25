package com.example.callingapiexample.fake

import com.example.callingapiexample.data.AmphibiansRepository
import com.example.callingapiexample.model.AmphibiansData

class FakeNetworkAmphibiansRepository: AmphibiansRepository {
    override suspend fun getAmphibians(): List<AmphibiansData> {
        return FakeDataSource.fakeDataList
    }
}