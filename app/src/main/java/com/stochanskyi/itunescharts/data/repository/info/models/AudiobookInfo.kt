package com.stochanskyi.itunescharts.data.repository.info.models

import com.stochanskyi.itunescharts.data.repository.info.ArtworkInfoRepository.IAudiobookInfo

data class AudiobookInfo(
    override val id: String,
    override val name: String,
    override val author: String,
    override val image: String,
    override val country: String,
    override val price: Float,
    override val description: String
) : IAudiobookInfo