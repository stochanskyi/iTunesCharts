package com.stochanskyi.itunescharts.data.network.features.audiobooks

import com.stochanskyi.itunescharts.data.network.features.audiobooks.models.AudiobooksCollection
import com.stochanskyi.itunescharts.data.network.services.RetrofitClient
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers

object AudiobooksProvider {
    fun provide(): Single<AudiobooksCollection> {
        val service = RetrofitClient.getRetrofitInstance().create(GetAudiobooksService::class.java)
        return service.audiobooks
                .subscribeOn(Schedulers.io())
                .map { it.audiobooksCollection }
    }

}