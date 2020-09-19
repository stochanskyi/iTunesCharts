package com.stochanskyi.itunescharts.data.network.features.info

import com.stochanskyi.itunescharts.data.network.common.SingleResultsList
import com.stochanskyi.itunescharts.data.network.features.info.responses.AudiobookInfoResponse
import com.stochanskyi.itunescharts.data.network.features.info.responses.MovieInfoResponse
import com.stochanskyi.itunescharts.data.network.features.info.responses.PodcastInfoResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ArtworkInfoApi {
    @GET("lookup")
    fun getAudiobookInfo(@Query("id") id: String): SingleResultsList<AudiobookInfoResponse>

    @GET("lookup")
    fun getMovieInfo(@Query("id") id: String): SingleResultsList<MovieInfoResponse>

    @GET("lookup")
    fun getPodcastInfo(@Query("id") id: String): SingleResultsList<PodcastInfoResponse>
}