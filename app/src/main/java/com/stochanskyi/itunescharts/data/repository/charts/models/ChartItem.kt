package com.stochanskyi.itunescharts.data.repository.charts.models

import com.stochanskyi.itunescharts.data.repository.charts.ChartsRepository


data class ChartItem(
    override val id: String,
    override val name: String,
    override val author: String,
    override val image: String,
    override val isFavourite: Boolean
) : ChartsRepository.IChartItem