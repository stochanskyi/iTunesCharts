package com.stochanskyi.itunescharts.presentation.fragments.audiobooks.presentation

import com.stochanskyi.itunescharts.data.DB.DBClient
import com.stochanskyi.itunescharts.data.network.features.audiobooks.AudiobooksProvider
import com.stochanskyi.itunescharts.data.network.features.audiobooks.models.AudiobookModel
import com.stochanskyi.itunescharts.data.network.features.audiobooks.models.AudiobooksCollection
import com.stochanskyi.itunescharts.presentation.base.MVP.BasePresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.rxkotlin.subscribeBy
import java.util.*

class AudiobooksPresenter private constructor() : BasePresenter<IAudiobooksView?>() {
    private lateinit var model: AudiobooksCollection

    private lateinit var disposable: Disposable

    override fun onStart() {
        if (!::model.isInitialized) {
            loadFromNetwork()
        } else {
            syncWithDB(model.audiobooks)
            view?.updateData(model.audiobooks)
        }
    }

    fun onShow() {
        if (::model.isInitialized) {
            syncWithDB(model.audiobooks)
            view?.updateData(model.audiobooks)
        }
    }

    private fun loadFromNetwork() {
        disposable = AudiobooksProvider.provide()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeBy(
                        onSuccess = {
                            model = it
                            syncWithDB(model.audiobooks)
                            view?.updateData(model.audiobooks)
                        },
                        onError = {
                            //Notify about no network connection
                        }
                )
    }

    private fun syncWithDB(audiobooks: ArrayList<AudiobookModel>) {
        for (i in audiobooks.indices) {
            val model = DBClient.getInstance().dbDao().getAudiobook(audiobooks[i].id)
            audiobooks[i].isFavourite = model != null
        }
    }

    fun onItemClicked(position: Int) {
        view?.toAudiobookInfo(model.audiobooks[position].id)
    }

    fun onStarLiked(position: Int) {
        val model = model.audiobooks[position]
        model.isFavourite = true
        DBClient.getInstance().dbDao().insertAudiobook(model)
    }

    fun onStartUnliked(position: Int) {
        val model = model.audiobooks[position]
        model.isFavourite = false
        DBClient.getInstance().dbDao().deleteAudiobook(this.model.audiobooks[position])
    }

    fun onRefresh() {
        loadFromNetwork()
        view?.onRefreshFinished()
    }

    override fun release() {
        disposable.dispose()
        super.release()
    }

    companion object {
        private var presenterInstance: AudiobooksPresenter? = null
        @JvmStatic
        val instance: AudiobooksPresenter?
            get() {
                if (presenterInstance == null) presenterInstance = AudiobooksPresenter()
                return presenterInstance
            }
    }
}