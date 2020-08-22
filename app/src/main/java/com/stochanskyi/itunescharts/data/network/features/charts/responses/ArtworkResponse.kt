package com.stochanskyi.itunescharts.data.network.features.charts.responses

import com.google.gson.annotations.SerializedName

data class ArtworkResponse(
    @SerializedName("id")
    val id: String,
    @SerializedName("artistName")
    val artistName: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("artworkUrl100")
    val image: String
)