package com.stochanskyi.itunesloader.data.network.features.info.podcastInfo

import com.stochanskyi.itunesloader.data.network.features.info.podcastInfo.models.PodcastInfoModel
import com.stochanskyi.itunesloader.data.network.features.info.podcastInfo.models.PodcastsResultsInfo
import com.stochanskyi.itunesloader.data.network.services.RetrofitClient
import io.reactivex.Observer
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
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