package com.stochanskyi.itunescharts.presentation.base.mvp

interface IBasePresenter<T : IBaseView> {
    var view: T?

    fun onCreate()
    fun onStart()
    fun onPause()
    fun onResume()

    fun release()
}