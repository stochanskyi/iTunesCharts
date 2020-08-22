package com.stochanskyi.itunescharts.data.network.features.info.audiobookInfo

import com.stochanskyi.itunescharts.data.network.features.info.audiobookInfo.models.AudiobookInfoModel
import com.stochanskyi.itunescharts.data.network.services.RetrofitClient
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers

object AudiobookInfoProvider {
    @JvmStatic
    fun provide(id: Int):Single<AudiobookInfoModel>  {
        val service = RetrofitClient.getRetrofitInfoInstance().create(AudiobookInfoService::class.java)
        return service.getInfo(id)
                .subscribeOn(Schedulers.io())
                .map { it.audiobooksResults[0] }
    }
}