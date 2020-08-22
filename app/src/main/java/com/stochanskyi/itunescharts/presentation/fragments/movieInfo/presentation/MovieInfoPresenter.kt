package com.stochanskyi.itunescharts.presentation.fragments.movieInfo.presentation

import com.stochanskyi.itunescharts.data.network.featuresOld.info.movieInfo.MovieInfoProvider
import com.stochanskyi.itunescharts.data.network.featuresOld.info.movieInfo.models.MovieInfoModel
import com.stochanskyi.itunescharts.presentation.base.MVP.BasePresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.rxkotlin.subscribeBy
import java.io.IOException

class MovieInfoPresenter : BasePresenter<IMovieInfoView?>() {

    private var movieID = 0
    private lateinit var model: MovieInfoModel

    private lateinit var disposable: Disposable


    override fun onStart() {
        disposable = MovieInfoProvider.provide(movieID)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeBy(
                        onSuccess = {
                            model = it
                            view?.setData(model)
                        },
                        onError = {
                            if (it is IOException) {
                                //No network connection
                            }
                        }
                )
    }

    override fun release() {
        disposable.dispose()
        super.release()
    }

    fun initMovieID(movieID: Int) {
        this.movieID = movieID
    }
}