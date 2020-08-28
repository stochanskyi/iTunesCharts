package com.stochanskyi.itunescharts.presentation.fragments.movies.presentation

import com.stochanskyi.itunescharts.data.DBOld.DBClient
import com.stochanskyi.itunescharts.data.network.featuresOld.movies.MoviesProvider
import com.stochanskyi.itunescharts.data.network.featuresOld.movies.models.MovieModel
import com.stochanskyi.itunescharts.data.network.featuresOld.movies.models.MoviesCollection
import com.stochanskyi.itunescharts.presentation.baseOld.MVP.BasePresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.rxkotlin.subscribeBy
import java.util.*

class MoviesPresenter private constructor() : BasePresenter<IMoviesView?>() {

    private lateinit var model: MoviesCollection

    private lateinit var disposable: Disposable

    override fun onStart() {
        if (!::model.isInitialized) {
            loadFromNetwork()
        } else {
            syncWithDB(model.movies)
            view?.updateData(model.movies)
        }
    }

    private fun loadFromNetwork() {
        disposable = MoviesProvider.provide()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeBy(
                        onSuccess = {
                            model = it
                            syncWithDB(model.movies)
                            view?.updateData(model.movies)
                        }
                )
    }

    fun onShow() {
        if (::model.isInitialized) {
            syncWithDB(model.movies)
            view?.updateData(model.movies)
        }
    }

    fun onRefresh() {
        loadFromNetwork()
        view?.onRefreshFinished()
    }

    private fun syncWithDB(movies: ArrayList<MovieModel>) {
        for (i in movies.indices) {
            val model = DBClient.getInstance().dbDao().getMovie(movies[i].id)
            movies[i].isFavourite = model != null
        }
    }

    fun onStarLiked(position: Int) {
        val movie = model.movies[position]
        movie.isFavourite = true
        DBClient.getInstance().dbDao().insertMovie(movie)
    }

    fun onStartUnliked(position: Int) {
        val movie = model.movies[position]
        movie.isFavourite = false
        DBClient.getInstance().dbDao().deleteMovie(movie)
    }

    fun onItemClicked(position: Int) {
        view?.toMovieInfo(model.movies[position].id)
    }

    companion object {
        private var presenterInstance: MoviesPresenter? = null
        @JvmStatic
        val instance: MoviesPresenter?
            get() {
                if (presenterInstance == null) presenterInstance = MoviesPresenter()
                return presenterInstance
            }
    }
}