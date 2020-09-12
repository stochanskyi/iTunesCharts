package com.stochanskyi.itunescharts.presentation.fragments.charts.adapter.viewHolders

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.stochanskyi.itunescharts.R
import com.stochanskyi.itunescharts.presentation.fragments.charts.ChartsContract.IChartItemViewModel
import kotlinx.android.synthetic.main.item_layout.view.*

class ChartsItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    companion object {
        fun create(parent: ViewGroup): ChartsItemViewHolder =
            ChartsItemViewHolder(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_layout, parent, false)
            )
    }

    fun bind(model: IChartItemViewModel, onClickBlock: (IChartItemViewModel) -> Unit) {
        itemView.apply {

            name.text = model.name
            artistName.text = model.author

            starButton.isLiked = model.isFavourite

            Glide.with(context)
                .load(model.image)
                .transform(RoundedCorners(15))
                .into(artworkImage)

            setOnClickListener { onClickBlock(model) }
        }
    }

    fun release() {
        itemView.setOnClickListener(null)
    }
}