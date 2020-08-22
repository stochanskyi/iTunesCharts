package com.stochanskyi.itunescharts.data.network.featuresOld.info.movieInfo

import com.stochanskyi.itunescharts.data.network.featuresOld.info.movieInfo.models.MovieInfoModel
import com.stochanskyi.itunescharts.data.network.services.RetrofitClient
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers

object MovieInfoProvider {
    @JvmStatic
    fun provide(id: Int): Single<MovieInfoModel> {

        val service = RetrofitClient.getRetrofitInfoInstance().create(MovieInfoService::class.java)

        return service.getInfo(id)
                .subscribeOn(Schedulers.io())
                .map { it.movieModels[0] }

    }
}