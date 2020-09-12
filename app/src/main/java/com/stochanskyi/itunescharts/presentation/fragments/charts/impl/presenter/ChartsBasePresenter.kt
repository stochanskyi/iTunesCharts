package com.stochanskyi.itunescharts.presentation.fragments.charts.impl.presenter

import androidx.annotation.CallSuper
import com.stochanskyi.itunescharts.data.network.common.SingleList
import com.stochanskyi.itunescharts.data.repository.charts.ChartsRepository
import com.stochanskyi.itunescharts.data.repository.charts.ChartsRepository.IChartItem
import com.stochanskyi.itunescharts.presentation.base.mvp.BasePresenter
import com.stochanskyi.itunescharts.presentation.fragments.charts.ChartsContract
import com.stochanskyi.itunescharts.presentation.fragments.charts.ChartsContract.IChartItemViewModel
import com.stochanskyi.itunescharts.presentation.fragments.charts.models.ChartItemViewModel
import io.reactivex.disposables.Disposable

abstract class ChartsBasePresenter(
    protected val chartsRepository: ChartsRepository
) : BasePresenter<ChartsContract.ViewContract>(),
    ChartsContract.PresenterContract {

    private var chartsLoadingDisposable: Disposable? = null

    @CallSuper
    override fun onStart() {
        updateItems()
    }

    protected abstract fun chartsLoadRequest(): SingleList<IChartItem>

    override fun onRefresh() {
        updateItems()
    }

    private fun updateItems() {
        chartsLoadingDisposable = chartsLoadRequest()
            .doOnSubscribe { view?.isRefreshing = true }
            .doFinally { view?.isRefreshing = false }
            .map { it.toViewModels() }
            .subscribe(
                { view?.setItems(it) },
                { view?.handleError(it) }
            )
    }

    override fun release() {
        super.release()
        chartsLoadingDisposable?.dispose()
    }

    private fun List<IChartItem>.toViewModels(): List<IChartItemViewModel> =
        map { it.toViewModel() }

    private fun IChartItem.toViewModel(): IChartItemViewModel =
        ChartItemViewModel(
            id,
            name,
            author,
            image,
            isFavourite
        )
}