package com.stochanskyi.itunescharts.data.network.features.charts

import com.stochanskyi.itunescharts.data.network.common.SingleFeedList
import com.stochanskyi.itunescharts.data.network.features.charts.responses.ArtworkResponse
import retrofit2.http.GET

interface ChartsApi {
    @GET("audiobooks/top-audiobooks/all/25/non-explicit.json")
    fun getTopAudiobooks(): SingleFeedList<ArtworkResponse>

    @GET("movies/top-movies/all/25/non-explicit.json")
    fun getTopMovies(): SingleFeedList<ArtworkResponse>

    @GET("podcasts/top-podcasts/all/25/non-explicit.json")
    fun getTopPodcasts(): SingleFeedList<ArtworkResponse>
}