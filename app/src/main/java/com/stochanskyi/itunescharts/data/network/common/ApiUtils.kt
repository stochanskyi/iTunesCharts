package com.stochanskyi.itunescharts.data.network.common

import com.stochanskyi.itunescharts.data.network.common.responses.FeedResponse
import com.stochanskyi.itunescharts.data.network.common.responses.ResultsResponse
import io.reactivex.Single

typealias SingleFeed<T> = Single<FeedResponse<T>>
typealias SingleResults<T> = Single<ResultsResponse<T>>
typealias SingleFeedList<T> = SingleFeed<List<T>>
typealias SingleResultsList<T> = SingleResults<List<T>>

fun <T> SingleFeed<T>.validateFeedResponse(): Single<T> = this.map { it.feed.data }

fun <T> SingleResults<T>.validateResultsResponse(): Single<T> = this.map { it.data }