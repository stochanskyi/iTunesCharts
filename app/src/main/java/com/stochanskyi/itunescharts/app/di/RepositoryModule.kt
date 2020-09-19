package com.stochanskyi.itunescharts.app.di

import com.stochanskyi.itunescharts.data.repository.charts.ChartsRepository
import com.stochanskyi.itunescharts.data.repository.charts.ChartsRepositoryImpl
import com.stochanskyi.itunescharts.data.repository.info.ArtworkInfoRepository
import com.stochanskyi.itunescharts.data.repository.info.ArtworkInfoRepositoryImpl

object RepositoryModule : KoinModule({
    single { ChartsRepositoryImpl(get()) as ChartsRepository }

    single { ArtworkInfoRepositoryImpl(get()) as ArtworkInfoRepository }
})