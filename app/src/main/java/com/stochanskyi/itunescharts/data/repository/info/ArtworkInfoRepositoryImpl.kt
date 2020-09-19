package com.stochanskyi.itunescharts.data.repository.info

import com.stochanskyi.itunescharts.data.network.features.info.ArtworkInfoSourceModel
import com.stochanskyi.itunescharts.data.network.features.info.responses.AudiobookInfoResponse
import com.stochanskyi.itunescharts.data.network.features.info.responses.MovieInfoResponse
import com.stochanskyi.itunescharts.data.network.features.info.responses.PodcastInfoResponse
import com.stochanskyi.itunescharts.data.repository.info.ArtworkInfoRepository.*
import com.stochanskyi.itunescharts.data.repository.info.models.AudiobookInfo
import com.stochanskyi.itunescharts.data.repository.info.models.MovieInfo
import com.stochanskyi.itunescharts.data.repository.info.models.PodcastInfo
import io.reactivex.Single

class ArtworkInfoRepositoryImpl(
    private val sourceModel: ArtworkInfoSourceModel
) : ArtworkInfoRepository {
    override fun getAudiobookInfo(id: String): Single<IAudiobookInfo> {
        return sourceModel.getAudiobookInfo(id)
            .parseAudiobook()
    }

    override fun getMovieInfo(id: String): Single<IMovieInfo> {
        return sourceModel.getMovieInfo(id)
            .parseMovie()
    }

    override fun getPodcastInfo(id: String): Single<IPodcastInfo> {
        return sourceModel.getPodcastInfo(id)
            .parsePodcast()
    }

    private fun Single<AudiobookInfoResponse>.parseAudiobook(): Single<IAudiobookInfo> {
        return map {
            it.run {
                AudiobookInfo(
                    id,
                    name,
                    artistName,
                    imageLink,
                    country,
                    price,
                    description
                )
            }
        }
    }

    private fun Single<MovieInfoResponse>.parseMovie(): Single<IMovieInfo> {
        return map {
            it.run {
                MovieInfo(
                    id,
                    name,
                    artistName,
                    imageLink,
                    country,
                    price,
                    hdPrice ?: -1f,
                    rentalPrice ?: -1f,
                    hdRentalPrice ?: -1f,
                    genre,
                    description
                )
            }
        }
    }

    private fun Single<PodcastInfoResponse>.parsePodcast(): Single<IPodcastInfo> {
        return map {
            it.run {
                PodcastInfo(
                    id,
                    name,
                    artistName,
                    imageLink,
                    country,
                    price,
                    genre,
                    rentalPrice ?: -1f
                )
            }
        }
    }
}