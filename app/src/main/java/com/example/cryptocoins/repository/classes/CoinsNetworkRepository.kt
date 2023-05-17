package com.example.cryptocoins.repository.classes

import com.example.cryptocoins.data.CoinModel
import com.example.cryptocoins.network.CoinsServiceApi
import com.example.cryptocoins.repository.interfaces.CoinsRepository

class CoinsNetworkRepository (
   val retrofit: CoinsServiceApi
        ): CoinsRepository {

    override suspend fun getListCoins(currency: String): List<CoinModel>
    = retrofit.getCoinsList(url ="markets?vs_currency=${currency}&order=market_cap_desc&per_page=5&page=1&sparkline=false&locale=en")
}