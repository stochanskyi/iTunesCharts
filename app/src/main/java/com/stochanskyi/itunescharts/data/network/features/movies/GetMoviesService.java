package com.stochanskyi.itunescharts.data.network.features.movies;

import com.stochanskyi.itunescharts.data.network.features.movies.models.MoviesFeed;

import io.reactivex.Single;
import retrofit2.http.GET;

public interface GetMoviesService {
    @GET("movies/top-movies/all/25/non-explicit.json")
    Single<MoviesFeed> getMovies();
}
