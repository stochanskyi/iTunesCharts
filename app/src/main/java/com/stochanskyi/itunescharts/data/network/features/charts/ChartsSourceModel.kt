package com.stochanskyi.itunescharts.data.network.features.charts

import com.stochanskyi.itunescharts.data.network.common.SingleList
import com.stochanskyi.itunescharts.data.network.features.charts.responses.ArtworkResponse

interface ChartsSourceModel {

    fun getTopAudiobooks(): SingleList<ArtworkResponse>

    fun getTopMovies(): SingleList<ArtworkResponse>

    fun getTopPodcasts(): SingleList<ArtworkResponse>

}