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
import com.example.cryptocoins.data.CoinModel
import com.example.cryptocoins.repository.interfaces.CoinsRepository
import com.example.cryptocoins.ui.viewmodels.interfaces.CoinsState
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

class CoinsViewModel(val coinsRepository: CoinsRepository):ViewModel() {

    var coinsUIState:CoinsState by mutableStateOf(CoinsState.Loading)
        private set

    var chipState by mutableStateOf(true)
        private set

    var isShowingMain by mutableStateOf(true)
        private set

    var currentCoin: CoinModel by mutableStateOf(
        CoinModel(
            id = "bitcoin",
            symbol = "btc",
            name = "Bitcoin",
            imageUrl = "https://assets.coingecko.com/coins/images/1/large/bitcoin.png?1547033579",
            currentPrice = null,
            priceChangePercentage24h = null
        )
    )
       private set

    fun updateCurrentCoin(coin:CoinModel){
        currentCoin = coin
    }
    fun onCardClicked(){
        isShowingMain = !isShowingMain
    }
    init {
        chipState = true
        getCoinsList("usd")
    }


    fun getCoinsList(currency: String){
        chipState = when(currency){
            "usd" -> true
            "eur" -> false
            else -> {true}
        }
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


}