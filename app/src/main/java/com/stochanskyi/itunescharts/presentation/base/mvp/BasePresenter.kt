package com.stochanskyi.itunescharts.presentation.base.mvp

import androidx.annotation.CallSuper

abstract class BasePresenter<T : IBaseView>: IBasePresenter<T> {
    override var view: T? = null

    override fun onCreate() {}

    override fun onStart() {}

    override fun onPause() {}

    override fun onResume() {}

    @CallSuper
    override fun release() {
        view = null
    }
}