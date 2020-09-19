package com.stochanskyi.itunescharts.data.network.features.info.responses

import com.google.gson.annotations.SerializedName

data class PodcastInfoResponse(
    @SerializedName("id")
    val id: String,
    @SerializedName("trackName")
    val name: String,
    @SerializedName("artistName")
    val artistName: String,
    @SerializedName("artworkUrl600")
    val imageLink: String,
    @SerializedName("trackPrice")
    val price: Float,
    @SerializedName("trackRentalPrice")
    val rentalPrice: Float?,
    @SerializedName("country")
    val country: String,
    @SerializedName("primaryGenreName")
    val genre: String
)