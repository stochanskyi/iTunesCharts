package com.stochanskyi.itunesloader.data.network.features.podcasts;

import com.stochanskyi.itunesloader.data.network.features.podcasts.models.PodcastsFeed;

import io.reactivex.Single;
import retrofit2.Call;
import retrofit2.http.GET;

public interface GetPodcastsService {
    @GET("podcasts/top-podcasts/all/25/non-explicit.json")
    Single<PodcastsFeed> getPodcasts();
}
