package com.stochanskyi.itunescharts.app.di

import com.stochanskyi.itunescharts.presentation.fragments.charts.ChartsContract
import com.stochanskyi.itunescharts.presentation.fragments.charts.impl.presenter.AudiobooksChartsPresenter
import com.stochanskyi.itunescharts.presentation.fragments.charts.impl.presenter.MoviesChartsPresenter
import com.stochanskyi.itunescharts.presentation.fragments.charts.impl.presenter.PodcastsChartsPresenter
import com.stochanskyi.itunescharts.presentation.fragments.charts.impl.presenter.PresenterType
import org.koin.core.qualifier.named


object PresentationModule : KoinModule({

    factory(named(PresenterType.AUDIOBOOKS)) { AudiobooksChartsPresenter(get()) as ChartsContract.PresenterContract }

    factory(named(PresenterType.MOVIES)) { MoviesChartsPresenter(get()) as ChartsContract.PresenterContract }

    factory(named(PresenterType.PODCASTS)) { PodcastsChartsPresenter(get()) as ChartsContract.PresenterContract }

})