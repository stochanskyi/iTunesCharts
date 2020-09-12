package com.stochanskyi.itunescharts.presentation.base.mvp

interface IBaseView {
    fun initViews() {}

    fun handleError(it: Throwable) {}
}