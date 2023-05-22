package com.example.cryptocoins.ui.viewmodels.interfaces

import com.example.cryptocoins.data.CoinModel

sealed interface CoinsState{
    data class Success(val coinsList:List<CoinModel>):CoinsState

    object Loading:CoinsState
    object Error:CoinsState
}