package com.stochanskyi.itunescharts.data.network.featuresOld.podcasts;

import com.stochanskyi.itunescharts.data.network.featuresOld.podcasts.models.PodcastsFeed;

import io.reactivex.Single;
import retrofit2.http.GET;

public interface GetPodcastsService {
    @GET("podcasts/top-podcasts/all/25/non-explicit.json")
    Single<PodcastsFeed> getPodcasts();
}
