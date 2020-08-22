package com.stochanskyi.itunesloader.data.network.features.podcasts

import com.stochanskyi.itunesloader.data.network.features.podcasts.models.PodcastsCollection
import com.stochanskyi.itunesloader.data.network.features.podcasts.models.PodcastsFeed
import com.stochanskyi.itunesloader.data.network.services.RetrofitClient
import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import retrofit2.Callback

object PodcastsProvider {
    @JvmStatic
    fun provide(): Single<PodcastsCollection> {
        val service = RetrofitClient.getRetrofitInstance().create(GetPodcastsService::class.java)
        return service.podcasts
                .subscribeOn(Schedulers.io())
                .map { it.feed }
    }
}