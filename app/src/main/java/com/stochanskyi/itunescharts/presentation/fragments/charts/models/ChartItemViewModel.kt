package com.stochanskyi.itunescharts.presentation.fragments.charts.models

import com.stochanskyi.itunescharts.presentation.fragments.charts.ChartsContract

data class ChartItemViewModel(
    override val id: String,
    override val name: String,
    override val author: String,
    override val image: String,
    override val isFavourite: Boolean
) : ChartsContract.IChartItemViewModel