package com.stochanskyi.itunescharts.data.network.features.movies

import com.stochanskyi.itunescharts.data.network.features.movies.models.MoviesCollection
import com.stochanskyi.itunescharts.data.network.services.RetrofitClient
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers

object MoviesProvider {
    @JvmStatic
    fun provide(): Single<MoviesCollection> {
        val service = RetrofitClient.getRetrofitInstance().create(GetMoviesService::class.java)
        return service.movies
                .subscribeOn(Schedulers.io())
                .map { it.feed }
    }
}