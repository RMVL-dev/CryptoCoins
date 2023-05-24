package com.example.cryptocoins.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class EnDescriptor(
    @SerialName("en")
    val descriptor: String?
)
