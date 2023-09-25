package com.example.callingapiexample

import com.example.callingapiexample.data.NetworkAmphibiansRepository
import com.example.callingapiexample.fake.FakeAmphibiansApiService
import com.example.callingapiexample.fake.FakeDataSource
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test

class NetworkAmphibiansRepositoryTest {

    @Test
    fun networkAmphibiansRepository_getAmphibians_verifyFakeDataList() =
        runTest {
            val repository = NetworkAmphibiansRepository(
                amphibiansApiService = FakeAmphibiansApiService()
            )
            assertEquals(FakeDataSource.fakeDataList, repository.getAmphibians())

        }
}