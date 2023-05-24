package com.example.cryptocoins.ui.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cryptocoins.repository.interfaces.CoinsRepository
import com.example.cryptocoins.ui.viewmodels.interfaces.CoinInfoState
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

class CoinsInfoViewModel(val coinsRepository: CoinsRepository):ViewModel() {

    var uiState:CoinInfoState by mutableStateOf(CoinInfoState.Loading)
        private set


    fun getCoinInfo(id:String){
        viewModelScope.launch{
            uiState = try {
                CoinInfoState.Success(
                    coinInfo = coinsRepository.getCoinInfo(id = id)
                )
            }catch (e:IOException){
                CoinInfoState.Error
            } catch (e:HttpException){
                CoinInfoState.Error
            }
        }
    }
}