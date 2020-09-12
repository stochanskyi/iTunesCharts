package com.stochanskyi.itunescharts.presentation.fragments.charts.impl.presenter

import com.stochanskyi.itunescharts.data.network.common.SingleList
import com.stochanskyi.itunescharts.data.repository.charts.ChartsRepository

class MoviesChartsPresenter(
    chartsRepository: ChartsRepository
) : ChartsBasePresenter(chartsRepository) {

    override fun chartsLoadRequest(): SingleList<ChartsRepository.IChartItem> {
        return chartsRepository.getMoviesCharts()
    }

    override fun onItemClicked(itemId: String) {
        //TODO implement item click
    }
}
