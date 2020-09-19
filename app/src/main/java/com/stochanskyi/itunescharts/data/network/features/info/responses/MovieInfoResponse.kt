package com.stochanskyi.itunescharts.data.network.features.info.responses

import com.google.gson.annotations.SerializedName

data class MovieInfoResponse(
    @SerializedName("id")
    val id: String,
    @SerializedName("trackName")
    var name: String,
    @SerializedName("artistName")
    val artistName: String,
    @SerializedName("artworkUrl100")
    val imageLink: String,
    @SerializedName("trackPrice")
    val price: Float,
    @SerializedName("trackRentalPrice")
    val rentalPrice: Float?,
    @SerializedName("trackHdPrice")
    val hdPrice: Float?,
    @SerializedName("trackHdRentalPrice")
    val hdRentalPrice: Float?,
    @SerializedName("primaryGenreName")
    val genre: String,
    @SerializedName("country")
    val country: String,
    @SerializedName("longDescription")
    val description: String
)