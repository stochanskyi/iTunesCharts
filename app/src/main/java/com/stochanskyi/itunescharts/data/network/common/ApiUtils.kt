package com.stochanskyi.itunescharts.data.network.common

import com.stochanskyi.itunescharts.data.network.common.responses.FeedResponse
import com.stochanskyi.itunescharts.data.network.common.responses.ResultsResponse
import io.reactivex.*
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

typealias SingleFeed<T> = Single<FeedResponse<T>>
typealias SingleResults<T> = Single<ResultsResponse<T>>
typealias SingleFeedList<T> = SingleFeed<List<T>>
typealias SingleResultsList<T> = SingleResults<List<T>>

typealias SingleList<T> = Single<List<T>>

fun <T> SingleFeed<T>.validateFeedResponse(): Single<T> = this.map { it.feed.data }

fun <T> SingleResults<T>.validateResultsResponse(): Single<T> = this.map { it.data }

fun <T> SingleResultsList<T>.validateItemInfoResponse(): Single<T> = this.map { it.data.first() }


fun <T> Observable<T>.apiSchedulers(): Observable<T> = this
    .subscribeOn(Schedulers.io())
    .observeOn(AndroidSchedulers.mainThread())

fun <T> Single<T>.apiSchedulers(): Single<T> = this
    .subscribeOn(Schedulers.io())
    .observeOn(AndroidSchedulers.mainThread())

fun <T> Maybe<T>.apiSchedulers(): Maybe<T> = this
    .subscribeOn(Schedulers.io())
    .observeOn(AndroidSchedulers.mainThread())

fun <T> Flowable<T>.apiSchedulers(): Flowable<T> = this
    .subscribeOn(Schedulers.io())
    .observeOn(AndroidSchedulers.mainThread())

fun Completable.apiSchedulers(): Completable = this
    .subscribeOn(Schedulers.io())
    .observeOn(AndroidSchedulers.mainThread())
