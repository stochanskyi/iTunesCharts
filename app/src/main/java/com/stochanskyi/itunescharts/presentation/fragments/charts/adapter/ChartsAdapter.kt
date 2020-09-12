package com.stochanskyi.itunescharts.presentation.fragments.charts.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.stochanskyi.itunescharts.presentation.fragments.charts.ChartsContract.IChartItemViewModel
import com.stochanskyi.itunescharts.presentation.fragments.charts.adapter.viewHolders.ChartsItemViewHolder
import com.stochanskyi.itunescharts.utils.clearAndAdd

class ChartsAdapter(
    private val onItemClickedBlock: (id: String) -> Unit
): RecyclerView.Adapter<ChartsItemViewHolder>() {

    private val items: MutableList<IChartItemViewModel> = mutableListOf()

    fun setItems(items: List<IChartItemViewModel>) {
        this.items.clearAndAdd(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChartsItemViewHolder {
        return ChartsItemViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: ChartsItemViewHolder, position: Int) {
        holder.bind(items[position]) { onItemClickedBlock(it.id) }
    }

    override fun onViewRecycled(holder: ChartsItemViewHolder) {
        holder.release()
    }

    override fun getItemCount(): Int = items.size
}