package com.stochanskyi.itunescharts.data.repository.info.models

import com.stochanskyi.itunescharts.data.repository.info.ArtworkInfoRepository.IMovieInfo

data class MovieInfo(
    override val id: String,
    override val name: String,
    override val author: String,
    override val image: String,
    override val country: String,
    override val price: Float,
    override val hdPrice: Float,
    override val rentalPrice: Float,
    override val hdRentalPrice: Float,
    override val genre: String,
    override val description: String
) : IMovieInfo