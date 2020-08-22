package com.stochanskyi.itunescharts.data.network.features.info.podcastInfo.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class PodcastsResultsInfo {
    @SerializedName("results")
    ArrayList<PodcastInfoModel> results;

    public PodcastsResultsInfo(ArrayList<PodcastInfoModel> results) {
        this.results = results;
    }

    public ArrayList<PodcastInfoModel> getResults() {
        return results;
    }
}
