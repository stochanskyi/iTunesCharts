package com.stochanskyi.itunescharts.data.network.features.info.responses

import com.google.gson.annotations.SerializedName

data class AudiobookInfoResponse(
    @SerializedName("id")
    val id: String,
    @SerializedName("collectionName")
    var name: String,
    @SerializedName("artistName")
    val artistName: String,
    @SerializedName("artworkUrl100")
    val imageLink: String,
    @SerializedName("collectionPrice")
    val price: Float,
    @SerializedName("country")
    val country: String,
    @SerializedName("description")
    val description: String
)