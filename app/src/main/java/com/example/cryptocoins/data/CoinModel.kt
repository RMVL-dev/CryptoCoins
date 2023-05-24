package com.example.cryptocoins.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient


@Serializable
data class CoinModel(
    @SerialName("id")
    val id:String?,
    @SerialName("symbol")
    val symbol:String?,
    @SerialName("name")
    val name:String?,
    @SerialName("image")
    val imageUrl:String?,
    @SerialName("current_price")
    val currentPrice:Double?,
    @SerialName("price_change_percentage_24h")
    val priceChangePercentage24h:Double?,
    )
