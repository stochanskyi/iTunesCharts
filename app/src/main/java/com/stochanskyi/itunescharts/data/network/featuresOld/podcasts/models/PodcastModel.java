package com.stochanskyi.itunescharts.data.network.featuresOld.podcasts.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;
import com.stochanskyi.itunescharts.presentation.base.models.IArtworkModel;

@Entity(tableName = "Podcasts")
public class PodcastModel implements IArtworkModel {
    @SerializedName("id") @PrimaryKey
    Integer id;
    @SerializedName("artistName")
    private String artistName;
    @SerializedName("name")
    private String name;
    @SerializedName("artworkUrl100")
    private String imageLink;
    private boolean isFavourite = false;

    public PodcastModel(Integer id, String artistName, String name, String imageLink, boolean isFavourite) {
        this.id = id;
        this.artistName = artistName;
        this.name = name;
        this.imageLink = imageLink;
        this.isFavourite = isFavourite;
    }

    public void setFavourite(boolean favourite) {
        isFavourite = favourite;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public String getArtistName() {
        return artistName;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getImageLink() {
        return imageLink;
    }

    public boolean isFavourite() {
        return isFavourite;
    }
}
