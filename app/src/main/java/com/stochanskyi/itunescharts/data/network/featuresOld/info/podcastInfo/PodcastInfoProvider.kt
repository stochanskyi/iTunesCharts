package com.stochanskyi.itunescharts.data.network.featuresOld.info.podcastInfo

import com.stochanskyi.itunescharts.data.network.featuresOld.info.podcastInfo.models.PodcastInfoModel
import com.stochanskyi.itunescharts.data.network.services.RetrofitClient
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers

object PodcastInfoProvider {
    @JvmStatic
    fun provide(id: Int): Single<PodcastInfoModel> {

        val service = RetrofitClient.getRetrofitInfoInstance().create(PodcastInfoService::class.java)

        return service.getInfo(id)
                .subscribeOn(Schedulers.io())
                .map { it.results[0] }
    }
}