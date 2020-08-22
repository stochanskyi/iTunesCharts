package com.stochanskyi.itunescharts.data.network.common.responses

import com.google.gson.annotations.SerializedName

data class ResultsResponse<T>(
    @SerializedName("title")
    val title: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("result")
    val data: T
)