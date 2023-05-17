package com.example.cryptocoins.repository.interfaces

import com.example.cryptocoins.data.CoinModel

interface CoinsRepository {
    suspend fun getListCoins(currency: String): List<CoinModel>
}