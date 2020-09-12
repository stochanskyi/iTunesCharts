package com.stochanskyi.itunescharts.data.database.favourites

import androidx.room.*
import com.stochanskyi.itunescharts.data.network.featuresOld.audiobooks.models.AudiobookModel
import com.stochanskyi.itunescharts.data.network.featuresOld.movies.models.MovieModel
import com.stochanskyi.itunescharts.data.network.featuresOld.podcasts.models.PodcastModel
import io.reactivex.Completable
import io.reactivex.Maybe

@Dao
interface FavouritesDao {

    @Query("SELECT * FROM Movies")
    fun getAllMovies(): Maybe<List<MovieModel>>

    @Query("SELECT * FROM Audiobooks")
    fun getAllAudiobooks(): Maybe<List<AudiobookModel>>

    @Query("SELECT * FROM Podcasts")
    fun getAllPodcasts(): Maybe<List<PodcastModel>>

    @Query("SELECT * FROM Audiobooks WHERE id = :id")
    fun getAudiobook(id: Int): AudiobookModel

    @Query("SELECT * FROM Movies WHERE id = :id")
    fun getMovie(id: Int): Maybe<MovieModel>

    @Query("SELECT * FROM Podcasts WHERE id = :id")
    fun getPodcast(id: Int): Maybe<PodcastModel>

    @Insert
    fun insertAudiobook(audiobookModel: AudiobookModel): Completable

    @Insert
    fun insertMovie(movie: MovieModel): Completable

    @Insert
    fun insertPodcast(podcastModel: PodcastModel): Completable

    @Update
    fun updateAudiobook(audiobookModel: AudiobookModel): Completable

    @Update
    fun updateMovie(movie: MovieModel): Completable

    @Update
    fun updatePodcast(podcastModel: PodcastModel): Completable

    @Delete
    fun deleteAudiobook(audiobookModel: AudiobookModel): Completable

    @Delete
    fun deleteMovie(movieModel: MovieModel): Completable

    @Delete
    fun deletePodcast(podcastModel: PodcastModel): Completable

}