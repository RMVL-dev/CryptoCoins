package com.example.cryptocoins.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

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
    val currentPrice:Int?,
    @SerialName("market_cap")
    val marketCap:Int?,
    @SerialName("market_cap_rank")
    val marketCapRank:Int?,
    @SerialName("fully_diluted_valuation")
    val fullyDilutedValuation:Int?,
    @SerialName("total_volume")
    val totalVolume:Int?,
    @SerialName("high_24h")
    val high24h:Int?,
    @SerialName("low_24h")
    val low24h:Int?,
    @SerialName("price_change_24h")
    val priceChange24h:Float?,
    @SerialName("price_change_percentage_24h")
    val priceChangePercentage24h:Float?,
    @SerialName("market_cap_change_24h")
    val marketCapChange24h:Int?,
    @SerialName("market_cap_change_percentage_24h")
    val marketCapChangePercentage24h:Float?,
    @SerialName("circulating_supply")
    val circulatingSupply:Int?,
    @SerialName("total_supply")
    val totalSupply:Int?,
    @SerialName("max_supply")
    val maxSupply:Int?,
    @SerialName("ath")
    val ath:Int?,
    @SerialName("ath_change_percentage")
    val athChangePercentage:Float?,
    @SerialName("ath_date")
    val ath_date:String?,
    @SerialName("atl")
    val atl:Float?,
    @SerialName("atl_change_percentage")
    val atlChangePercentage:Float?,
    @SerialName("atl_date")
    val atlDate:String?,
    @SerialName("roi")
    val roi:Roi?,
    @SerialName("last_updated")
    val last_updated:String?
    )
