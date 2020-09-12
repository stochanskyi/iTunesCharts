package com.stochanskyi.itunescharts.presentation.base.mvp

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment

abstract class BaseFragment<T : IBasePresenter<out IBaseFragment> > :
    Fragment(),
    IBaseFragment {

    abstract val presenter: T

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initPresenter()
        initViews()
        presenter.onStart()
    }

    abstract fun initPresenter()

    override fun close() {
        parentFragment?.let {
            if (it.childFragmentManager.backStackEntryCount > 0) {
                it.childFragmentManager.popBackStack()
            }
        } ?: activity?.let {
            if (it.supportFragmentManager.backStackEntryCount > 0) {
                it.supportFragmentManager.popBackStack()
            }
        }
    }
}