package com.stochanskyi.itunescharts.data.network.featuresOld.movies.models;

import com.google.gson.annotations.SerializedName;

public class MoviesFeed {
    @SerializedName("feed")
    private MoviesCollection feed;

    public MoviesFeed(MoviesCollection feed) {
        this.feed = feed;
    }

    public void setFeed(MoviesCollection feed) {
        this.feed = feed;
    }

    public MoviesCollection getFeed() {
        return feed;
    }
}
