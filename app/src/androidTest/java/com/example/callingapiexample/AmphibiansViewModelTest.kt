package com.example.callingapiexample

import com.example.callingapiexample.fake.FakeDataSource
import com.example.callingapiexample.fake.FakeNetworkAmphibiansRepository
import com.example.callingapiexample.model.screen.AmphibiansUiState
import com.example.callingapiexample.model.screen.AmphibiansViewModel
import com.example.callingapiexample.rules.TestDispatcherRule
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test

class AmphibiansViewModelTest {

    @get:Rule
    val testDispatcher = TestDispatcherRule()

    @Test
    fun amphibiansViewModel_getAmphibians_verifyAmphibiansUiStateSuccess() =
        runTest {
            val amphibiansViewModel = AmphibiansViewModel(
                amphibiansRepository =  FakeNetworkAmphibiansRepository()
            )
            assertEquals(
                AmphibiansUiState.Success(FakeDataSource.fakeDataList),
                amphibiansViewModel.amphibiansUiState
            )
        }
}