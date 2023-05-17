package com.example.cryptocoins.network

import com.example.cryptocoins.data.CoinModel
import retrofit2.http.GET
import retrofit2.http.Url

interface CoinsServiceApi {
    @GET
    suspend fun getCoinsList(@Url url:String): List<CoinModel>
}