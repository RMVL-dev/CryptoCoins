package com.example.cryptocoins.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Roi(
    @SerialName("times")
    val times: Float,
    @SerialName("currency")
    val currency: String,
    @SerialName("percentage")
    val percentage: Float,
)
