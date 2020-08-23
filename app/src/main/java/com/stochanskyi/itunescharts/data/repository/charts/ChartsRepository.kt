package com.stochanskyi.itunescharts.data.repository.charts

import com.stochanskyi.itunescharts.data.network.common.SingleList

interface ChartsRepository {

    fun getAudiobooksCharts(): SingleList<IChartItem>

    fun getMoviesCharts(): SingleList<IChartItem>

    fun getPodcastsCharts(): SingleList<IChartItem>

    interface IChartItem {
        val id: String
        val name: String
        val author: String
        val image: String
        val isFavourite: Boolean
    }

    interface IMovieDetailedItem : IChartItem {

    }

    interface IAudiobookDetailedItem : IChartItem {

    }

    interface IPodcastDetailedItem : IChartItem {

    }
}