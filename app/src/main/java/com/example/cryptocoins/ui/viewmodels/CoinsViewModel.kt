package com.example.cryptocoins.ui.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.cryptocoins.CoinsApplication
import com.example.cryptocoins.repository.interfaces.CoinsRepository
import com.example.cryptocoins.ui.viewmodels.interfaces.CoinsState
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

class CoinsViewModel(val coinsRepository: CoinsRepository):ViewModel() {

    var coinsUIState:CoinsState by mutableStateOf(CoinsState.Loading)
        private set



    fun getCoinsList(currency: String){

        viewModelScope.launch {
            coinsUIState = try {
                CoinsState.Success(
                    coinsRepository.getListCoins(currency = currency)
                )
            }catch (e:IOException){
                CoinsState.Error
            }catch (e:HttpException){
                CoinsState.Error
            }
        }

    }



    companion object{
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as CoinsApplication)
                val coinsRepository = application.container.coinsRepository
                CoinsViewModel(coinsRepository = coinsRepository)
            }
        }
    }



}