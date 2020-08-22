package com.stochanskyi.itunescharts.data.network.features.info.movieInfo.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class MoviesResultsInfo {
    @SerializedName("results")
    ArrayList<MovieInfoModel> movieModels;

    public MoviesResultsInfo(ArrayList<MovieInfoModel> movieModels) {
        this.movieModels = movieModels;
    }

    public ArrayList<MovieInfoModel> getMovieModels() {
        return movieModels;
    }
}
