package com.example.cryptocoins.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CoinDescriptor(
    @SerialName("description")
    val description:EnDescriptor?
)
