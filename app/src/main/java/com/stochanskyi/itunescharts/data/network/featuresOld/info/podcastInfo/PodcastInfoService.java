package com.stochanskyi.itunescharts.data.network.featuresOld.info.podcastInfo;

import com.stochanskyi.itunescharts.data.network.featuresOld.info.podcastInfo.models.PodcastsResultsInfo;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PodcastInfoService {
    @GET("lookup")
    Single<PodcastsResultsInfo> getInfo(@Query("id") int id);
}
