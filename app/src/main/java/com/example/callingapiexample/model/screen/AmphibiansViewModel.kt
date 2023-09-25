package com.example.callingapiexample.model.screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.callingapiexample.AmphibiansApplication
import com.example.callingapiexample.data.AmphibiansRepository
import com.example.callingapiexample.model.AmphibiansData

import kotlinx.coroutines.launch
import java.io.IOException

sealed interface AmphibiansUiState{
    data class Success(val amphibians: List<AmphibiansData>): AmphibiansUiState
    object Loading: AmphibiansUiState
    object Error: AmphibiansUiState
}

class AmphibiansViewModel(val amphibiansRepository: AmphibiansRepository): ViewModel() {

    var amphibiansUiState: AmphibiansUiState by mutableStateOf(AmphibiansUiState.Loading)
        private set

    init {
        getAmphibiansData()
    }

    private fun getAmphibiansData(){
        viewModelScope.launch {
            amphibiansUiState = AmphibiansUiState.Loading

            amphibiansUiState = try {
                // create a new variable for holding data and inherit NetworkAmphibiansRepository class
               // val listResult = ApiConstant.retrofitService.getPhotos()
                //instead of using ApiConstant to call data we use repository
                val listResult = amphibiansRepository.getAmphibians()
                AmphibiansUiState.Success(listResult)
            }catch (e: IOException){
                AmphibiansUiState.Error
            }catch (e: IOException){
                AmphibiansUiState.Loading
            }
        }
    }
    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as AmphibiansApplication)
                val amphibiansRepository = application.container.amphibiansRepository
                AmphibiansViewModel(amphibiansRepository = amphibiansRepository)
            }
        }
    }


}