package com.stochanskyi.itunescharts.data.network.featuresOld.podcasts

import com.stochanskyi.itunescharts.data.network.featuresOld.podcasts.models.PodcastsCollection
import com.stochanskyi.itunescharts.data.network.services.RetrofitClient
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers

object PodcastsProvider {
    @JvmStatic
    fun provide(): Single<PodcastsCollection> {
        val service = RetrofitClient.getRetrofitInstance().create(GetPodcastsService::class.java)
        return service.podcasts
                .subscribeOn(Schedulers.io())
                .map { it.feed }
    }
}