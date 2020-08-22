package com.stochanskyi.itunescharts.data.network.featuresOld.info.movieInfo;

import com.stochanskyi.itunescharts.data.network.featuresOld.info.movieInfo.models.MoviesResultsInfo;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MovieInfoService {
    @GET("lookup")
    Single<MoviesResultsInfo> getInfo(@Query("id") int id);
}
