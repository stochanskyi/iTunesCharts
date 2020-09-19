package com.stochanskyi.itunescharts.data.network.features.info

import com.stochanskyi.itunescharts.data.network.features.info.responses.AudiobookInfoResponse
import com.stochanskyi.itunescharts.data.network.features.info.responses.MovieInfoResponse
import com.stochanskyi.itunescharts.data.network.features.info.responses.PodcastInfoResponse
import io.reactivex.Single

interface ArtworkInfoSourceModel {

    fun getAudiobookInfo(id: String): Single<AudiobookInfoResponse>

    fun getMovieInfo(id: String): Single<MovieInfoResponse>

    fun getPodcastInfo(id: String): Single<PodcastInfoResponse>

}