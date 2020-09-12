package com.stochanskyi.itunescharts.presentation.fragments.charts.impl

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.stochanskyi.itunescharts.R
import com.stochanskyi.itunescharts.presentation.base.mvp.BaseFragment
import com.stochanskyi.itunescharts.presentation.fragments.charts.ChartsContract
import com.stochanskyi.itunescharts.presentation.fragments.charts.adapter.ChartsAdapter
import com.stochanskyi.itunescharts.presentation.fragments.charts.impl.presenter.PresenterType
import kotlinx.android.synthetic.main.fragment_items_view.*
import org.koin.android.ext.android.get
import org.koin.core.qualifier.named

class ChartsFragment : BaseFragment<ChartsContract.PresenterContract>(),
        ChartsContract.ViewContract {

    companion object {
        private const val PRESENTER_TYPE_KEY = "presenter_type_key"
        fun newInstance(type: PresenterType): ChartsFragment {
            return ChartsFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(PRESENTER_TYPE_KEY, type)
                }
            }
        }
    }

    override lateinit var presenter: ChartsContract.PresenterContract

    override fun initPresenter() {
        presenter.view = this
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (arguments?.getSerializable(PRESENTER_TYPE_KEY) as? PresenterType)?.let {
            injectPresenter(it)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_items_view, container, false)
    }

    override var isRefreshing: Boolean
        get() = swipeLayout.isRefreshing
        set(value) {
            if (isRefreshing == value) return

            swipeLayout.isRefreshing = value
        }

    override fun initViews() {
        itemsRecycler.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = ChartsAdapter { presenter.onItemClicked(it) }
        }

        swipeLayout.setOnRefreshListener { presenter.onRefresh() }
    }

    override fun setItems(items: List<ChartsContract.IChartItemViewModel>) {
        adapterAction { setItems(items) }
    }

    override fun openArtworkInfo(itemId: String) {
        //TODO not yet implemented
    }

    private fun injectPresenter(type: PresenterType) {
        presenter = get(named(type))
    }

    private fun adapterAction(action: ChartsAdapter.() -> Unit) {
        (itemsRecycler.adapter as? ChartsAdapter)?.action()
    }
}