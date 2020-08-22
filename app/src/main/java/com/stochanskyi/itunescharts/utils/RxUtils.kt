package com.stochanskyi.itunescharts.utils

import io.reactivex.*
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

fun <T> Observable<T>.onApiThread(): Observable<T> = this
        .subscribeOn(Schedulers.io())
        .observeOn(Schedulers.io())

fun <T> Single<T>.onApiThread(): Single<T> = this
        .subscribeOn(Schedulers.io())
        .observeOn(Schedulers.io())

fun <T> Maybe<T>.onApiThread(): Maybe<T> = this
        .subscribeOn(Schedulers.io())
        .observeOn(Schedulers.io())

fun <T> Flowable<T>.onApiThread(): Flowable<T> = this
        .subscribeOn(Schedulers.io())
        .observeOn(Schedulers.io())

fun Completable.onApiThread(): Completable = this
        .subscribeOn(Schedulers.io())
        .observeOn(Schedulers.io())

fun <T> Observable<T>.onComputationThread(): Observable<T> = this
        .subscribeOn(Schedulers.computation())
        .observeOn(Schedulers.computation())

fun <T> Single<T>.onComputationThread(): Single<T> = this
        .subscribeOn(Schedulers.computation())
        .observeOn(Schedulers.computation())

fun <T> Maybe<T>.onComputationThread(): Maybe<T> = this
        .subscribeOn(Schedulers.computation())
        .observeOn(Schedulers.computation())

fun <T> Flowable<T>.onComputationThread(): Flowable<T> = this
        .subscribeOn(Schedulers.computation())
        .observeOn(Schedulers.computation())

fun Completable.onComputationThread(): Completable = this
        .subscribeOn(Schedulers.computation())
        .observeOn(Schedulers.computation())

fun <T> Observable<T>.onUiThread(): Observable<T> = this
        .subscribeOn(AndroidSchedulers.mainThread())
        .observeOn(AndroidSchedulers.mainThread())

fun <T> Single<T>.onUiThread(): Single<T> = this
        .subscribeOn(AndroidSchedulers.mainThread())
        .observeOn(AndroidSchedulers.mainThread())

fun <T> Maybe<T>.onUiThread(): Maybe<T> = this
        .subscribeOn(AndroidSchedulers.mainThread())
        .observeOn(AndroidSchedulers.mainThread())

fun <T> Flowable<T>.onUiThread(): Flowable<T> = this
        .subscribeOn(AndroidSchedulers.mainThread())
        .observeOn(AndroidSchedulers.mainThread())

fun Completable.onUiThread(): Completable = this
        .subscribeOn(AndroidSchedulers.mainThread())
        .observeOn(AndroidSchedulers.mainThread())

fun <T> Observable<T>.observeOnUI(): Observable<T> = this
        .observeOn(AndroidSchedulers.mainThread())

fun <T> Single<T>.observeOnUI(): Single<T> = this
        .observeOn(AndroidSchedulers.mainThread())

fun <T> Maybe<T>.observeOnUI(): Maybe<T> = this
        .observeOn(AndroidSchedulers.mainThread())

fun <T> Flowable<T>.observeOnUI(): Flowable<T> = this
        .observeOn(AndroidSchedulers.mainThread())

fun Completable.observeOnUI(): Completable = this
        .observeOn(AndroidSchedulers.mainThread())


fun Disposable.ignore() {}



