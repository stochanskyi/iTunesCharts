package com.stochanskyi.itunescharts.data.network.features.info.audiobookInfo;

import com.stochanskyi.itunescharts.data.network.features.info.audiobookInfo.models.AudiobooksResultsInfo;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface AudiobookInfoService {
    @GET("lookup")
    Single<AudiobooksResultsInfo> getInfo(@Query("id") int id);
}
