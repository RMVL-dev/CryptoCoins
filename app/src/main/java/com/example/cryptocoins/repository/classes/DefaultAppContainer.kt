package com.example.cryptocoins.repository.classes

import com.example.cryptocoins.network.CoinsServiceApi
import com.example.cryptocoins.repository.interfaces.AppContainer
import com.example.cryptocoins.repository.interfaces.CoinsRepository
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

class DefaultAppContainer: AppContainer {

    private val BASE_URL =
        "https://api.coingecko.com/api/v3/coins/"

    @OptIn(ExperimentalSerializationApi::class)
    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(Json{ignoreUnknownKeys = true}.asConverterFactory("json/application".toMediaType()))
        .build()

    private val retrofitService: CoinsServiceApi by lazy {
        retrofit.create(CoinsServiceApi::class.java)
    }

    override val coinsRepository: CoinsRepository by lazy {
        CoinsNetworkRepository(retrofit = retrofitService)
    }
}