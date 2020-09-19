package com.stochanskyi.itunescharts.data.repository.info

import io.reactivex.Single

interface ArtworkInfoRepository {
    fun getAudiobookInfo(id: String): Single<IAudiobookInfo>

    fun getMovieInfo(id: String): Single<IMovieInfo>

    fun getPodcastInfo(id: String): Single<IPodcastInfo>

    interface IArtworkInfo {
        val id: String
        val name: String
        val author: String
        val image: String
        val country: String
        val price: Float
    }

    interface IAudiobookInfo : IArtworkInfo {
        val description: String
    }

    interface IMovieInfo : IArtworkInfo {
        val hdPrice: Float
        val rentalPrice: Float
        val hdRentalPrice: Float
        val genre: String
        val description: String
    }

    interface IPodcastInfo : IArtworkInfo {
        val genre: String
        val rentalPrice: Float
    }

}