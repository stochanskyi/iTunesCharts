package com.stochanskyi.itunescharts.data.repository.charts

import com.stochanskyi.itunescharts.data.network.common.SingleList
import com.stochanskyi.itunescharts.data.network.features.charts.ChartsSourceModel
import com.stochanskyi.itunescharts.data.network.features.charts.responses.ArtworkResponse
import com.stochanskyi.itunescharts.data.repository.charts.ChartsRepository.IChartItem
import com.stochanskyi.itunescharts.data.repository.charts.models.ChartItem
import io.reactivex.Single

class ChartsRepositoryImpl(
    private val chartsSourceModel: ChartsSourceModel
) : ChartsRepository {

    override fun getAudiobooksCharts(): SingleList<IChartItem> {
        return chartsSourceModel.getTopAudiobooks()
            .flatMap { it.parseWithFavouriteCheck() }
    }

    override fun getMoviesCharts(): SingleList<IChartItem> {
        return chartsSourceModel.getTopMovies()
            .flatMap { it.parseWithFavouriteCheck() }
    }

    override fun getPodcastsCharts(): SingleList<IChartItem> {
        return chartsSourceModel.getTopPodcasts()
            .flatMap { it.parseWithFavouriteCheck() }
    }

    private fun List<ArtworkResponse>.parseWithFavouriteCheck(): SingleList<IChartItem> {
        return Single.just(this.map { it.parse(false) })
        //TODO Check favourites
    }

    private fun ArtworkResponse.parse(isFavourite: Boolean): IChartItem {
        return ChartItem(
            id,
            name,
            artistName,
            image,
            isFavourite
        )
    }

}