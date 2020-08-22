package com.stochanskyi.itunescharts.data.network.features.charts

import com.stochanskyi.itunescharts.data.network.common.SingleList
import com.stochanskyi.itunescharts.data.network.common.apiSchedulers
import com.stochanskyi.itunescharts.data.network.common.validateFeedResponse
import com.stochanskyi.itunescharts.data.network.features.charts.responses.ArtworkResponse

class ChartsSourceModelImpl(
    private val api: ChartsApi
): ChartsSourceModel {

    override fun getTopAudiobooks(): SingleList<ArtworkResponse> {
        return api.getTopAudiobooks()
            .validateFeedResponse()
            .apiSchedulers()
    }

    override fun getTopMovies(): SingleList<ArtworkResponse> {
        return api.getTopMovies()
            .validateFeedResponse()
            .apiSchedulers()
    }

    override fun getTopPodcasts(): SingleList<ArtworkResponse> {
        return api.getTopPodcasts()
            .validateFeedResponse()
            .apiSchedulers()
    }
}