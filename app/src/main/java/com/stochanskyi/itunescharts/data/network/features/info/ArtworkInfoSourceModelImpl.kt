package com.stochanskyi.itunescharts.data.network.features.info

import com.stochanskyi.itunescharts.data.network.common.validateItemInfoResponse
import com.stochanskyi.itunescharts.data.network.features.info.responses.AudiobookInfoResponse
import com.stochanskyi.itunescharts.data.network.features.info.responses.MovieInfoResponse
import com.stochanskyi.itunescharts.data.network.features.info.responses.PodcastInfoResponse
import com.stochanskyi.itunescharts.utils.onApiThread
import io.reactivex.Single

class ArtworkInfoSourceModelImpl(
    private val api: ArtworkInfoApi
): ArtworkInfoSourceModel {

    override fun getAudiobookInfo(id: String): Single<AudiobookInfoResponse> {
        return api.getAudiobookInfo(id)
            .validateItemInfoResponse()
            .onApiThread()
    }

    override fun getMovieInfo(id: String): Single<MovieInfoResponse> {
        return api.getMovieInfo(id)
            .validateItemInfoResponse()
            .onApiThread()
    }

    override fun getPodcastInfo(id: String): Single<PodcastInfoResponse> {
        return api.getPodcastInfo(id)
            .validateItemInfoResponse()
            .onApiThread()
    }
}