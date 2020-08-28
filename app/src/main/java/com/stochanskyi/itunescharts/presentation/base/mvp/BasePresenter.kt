package com.stochanskyi.itunescharts.presentation.base.mvp

abstract class BasePresenter<T : IBaseView>: IBasePresenter<T> {
    override var view: T? = null

    override fun onCreate() {}

    override fun onStart() {}

    override fun onPause() {}

    override fun onResume() {}

    override fun release() {
        view = null
    }
}