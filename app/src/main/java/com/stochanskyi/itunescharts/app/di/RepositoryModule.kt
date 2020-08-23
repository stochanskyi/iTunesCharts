package com.stochanskyi.itunescharts.app.di

import com.stochanskyi.itunescharts.data.repository.charts.ChartsRepository
import com.stochanskyi.itunescharts.data.repository.charts.ChartsRepositoryImpl

object RepositoryModule : KoinModule({
    single { ChartsRepositoryImpl(get()) as ChartsRepository }
})