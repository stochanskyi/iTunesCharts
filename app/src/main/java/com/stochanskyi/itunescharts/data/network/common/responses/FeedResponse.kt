package com.stochanskyi.itunescharts.data.network.common.responses

import com.google.gson.annotations.SerializedName

data class FeedResponse<T>(
    @SerializedName("feed")
    val feed: ResultsResponse<T>
)