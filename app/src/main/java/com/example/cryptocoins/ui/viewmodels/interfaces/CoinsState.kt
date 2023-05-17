package com.example.cryptocoins.ui.viewmodels.interfaces

import com.example.cryptocoins.data.CoinModel

sealed interface CoinsState{
    data class Success(val coinsList:List<CoinModel>):CoinsState

    object Error:CoinsState

    object Loading:CoinsState
}