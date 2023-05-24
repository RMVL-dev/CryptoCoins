package com.example.cryptocoins.ui.viewmodels.interfaces

import com.example.cryptocoins.data.CoinDescriptor

sealed interface CoinInfoState{

    class Success(val coinInfo:CoinDescriptor):CoinInfoState

    object Loading:CoinInfoState

    object Error:CoinInfoState

}