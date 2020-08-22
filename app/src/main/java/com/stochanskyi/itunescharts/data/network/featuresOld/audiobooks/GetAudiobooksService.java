package com.stochanskyi.itunescharts.data.network.featuresOld.audiobooks;

import com.stochanskyi.itunescharts.data.network.featuresOld.audiobooks.models.AudiobooksFeed;
import io.reactivex.Single;
import retrofit2.http.GET;


public interface GetAudiobooksService {

    @GET("audiobooks/top-audiobooks/all/25/non-explicit.json")
    Single<AudiobooksFeed> getAudiobooks();
}
