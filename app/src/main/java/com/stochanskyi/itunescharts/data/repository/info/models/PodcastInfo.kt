package com.stochanskyi.itunescharts.data.repository.info.models

import com.stochanskyi.itunescharts.data.repository.info.ArtworkInfoRepository

data class PodcastInfo(
    override val id: String,
    override val name: String,
    override val author: String,
    override val image: String,
    override val country: String,
    override val price: Float,
    override val genre: String,
    override val rentalPrice: Float
) : ArtworkInfoRepository.IPodcastInfo