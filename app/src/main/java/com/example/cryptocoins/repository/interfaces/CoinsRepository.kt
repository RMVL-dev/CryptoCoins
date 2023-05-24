package com.example.cryptocoins.repository.interfaces

import com.example.cryptocoins.data.CoinDescriptor
import com.example.cryptocoins.data.CoinModel

interface CoinsRepository {
    suspend fun getListCoins(currency: String): List<CoinModel>

    suspend fun getCoinInfo(id:String): CoinDescriptor
}