package com.example.callingapiexample.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AmphibiansData(
    val name: String,
    val type:String,
    val description: String,
    @SerialName("img_src")
    val imgSrc: String
)
