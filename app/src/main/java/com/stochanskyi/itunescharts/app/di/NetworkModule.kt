package com.stochanskyi.itunescharts.app.di

import com.stochanskyi.itunescharts.data.network.common.RetrofitAdapter
import com.stochanskyi.itunescharts.data.network.features.charts.ChartsSourceModel
import com.stochanskyi.itunescharts.data.network.features.charts.ChartsSourceModelImpl
import com.stochanskyi.itunescharts.data.network.features.info.ArtworkInfoSourceModel
import com.stochanskyi.itunescharts.data.network.features.info.ArtworkInfoSourceModelImpl

object NetworkModule : KoinModule({

    val retrofitAdapter = RetrofitAdapter()

    single { retrofitAdapter.chartsApiService }

    single { retrofitAdapter.infoApiService }

    single { ChartsSourceModelImpl(get()) as ChartsSourceModel }

    single { ArtworkInfoSourceModelImpl(get()) as ArtworkInfoSourceModel }
})
