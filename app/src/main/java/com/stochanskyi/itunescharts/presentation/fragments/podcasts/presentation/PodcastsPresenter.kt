package com.stochanskyi.itunescharts.presentation.fragments.podcasts.presentation

import com.stochanskyi.itunescharts.data.DB.DBClient
import com.stochanskyi.itunescharts.data.network.featuresOld.podcasts.PodcastsProvider
import com.stochanskyi.itunescharts.data.network.featuresOld.podcasts.models.PodcastModel
import com.stochanskyi.itunescharts.data.network.featuresOld.podcasts.models.PodcastsCollection
import com.stochanskyi.itunescharts.presentation.base.MVP.BasePresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.rxkotlin.subscribeBy
import java.util.*

class PodcastsPresenter private constructor() : BasePresenter<IPodcastsView?>() {

    private lateinit var model: PodcastsCollection

    private lateinit var disposable: Disposable

    override fun onStart() {
        if (!::model.isInitialized) {
            loadFromNetwork()
        } else {
            syncWithDB(model.podcasts)
            view?.updateData(model.podcasts)
        }
    }

    fun onItemClick(position: Int) {
        val id = model.podcasts[position].id
        view?.toPodcastInfo(id)
    }

    private fun loadFromNetwork() {
        disposable = PodcastsProvider.provide()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeBy(
                        onSuccess = {
                            model = it
                            syncWithDB(model.podcasts)
                            view?.updateData(model.podcasts)
                        }
                )
    }

    fun onShow() {
        if (::model.isInitialized) {
            syncWithDB(model.podcasts)
            view?.updateData(model.podcasts)
        }
    }

    private fun syncWithDB(podcasts: ArrayList<PodcastModel>) {
        for (i in podcasts.indices) {
            val model = DBClient.getInstance().dbDao().getPodcast(podcasts[i].id)
            podcasts[i].isFavourite = model != null
        }
    }

    fun onStarLiked(position: Int) {
        val podcast = model.podcasts[position]
        podcast.isFavourite = true
        DBClient.getInstance().dbDao().insertPodcast(podcast)
    }

    fun onStartUnliked(position: Int) {
        val podcast = model.podcasts[position]
        podcast.isFavourite = false
        DBClient.getInstance().dbDao().deletePodcast(podcast)
    }

    fun onRefresh() {
        loadFromNetwork()
        view?.onRefreshFinished()
    }

    companion object {
        private var presenterInstance: PodcastsPresenter? = null
        @JvmStatic
        val instance: PodcastsPresenter?
            get() {
                if (presenterInstance == null) presenterInstance = PodcastsPresenter()
                return presenterInstance
            }
    }
}