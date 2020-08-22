package com.stochanskyi.itunescharts.app.di

import com.stochanskyi.itunescharts.data.network.common.RetrofitAdapter
import com.stochanskyi.itunescharts.data.network.features.charts.ChartsSourceModel
import com.stochanskyi.itunescharts.data.network.features.charts.ChartsSourceModelImpl

object NetworkModule : KoinModule({

    val retrofitAdapter = RetrofitAdapter()

    single { retrofitAdapter.chartsApiService }

    single { ChartsSourceModelImpl(get()) as ChartsSourceModel }

})
