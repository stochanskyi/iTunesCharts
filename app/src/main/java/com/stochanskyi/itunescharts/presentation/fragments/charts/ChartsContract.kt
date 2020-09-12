package com.stochanskyi.itunescharts.presentation.fragments.charts

import com.stochanskyi.itunescharts.presentation.base.mvp.IBaseFragment
import com.stochanskyi.itunescharts.presentation.base.mvp.IBasePresenter

interface ChartsContract {

    interface ViewContract : IBaseFragment {
        var isRefreshing: Boolean

        fun setItems(items: List<IChartItemViewModel>)

        fun openArtworkInfo(itemId: String)
    }

    interface PresenterContract : IBasePresenter<ViewContract> {
        fun onRefresh()

        fun onItemClicked(itemId: String)
    }

    interface IChartItemViewModel {
        val id: String
        val name: String
        val author: String
        val image: String
        val isFavourite: Boolean
    }

}