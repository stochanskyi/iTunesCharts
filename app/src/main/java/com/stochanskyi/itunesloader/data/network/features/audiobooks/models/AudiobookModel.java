package com.stochanskyi.itunesloader.data.network.features.audiobooks.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;
import com.stochanskyi.itunesloader.presentation.base.models.IArtworkModel;

@Entity(tableName = "Audiobooks")
public class AudiobookModel implements IArtworkModel {

    @PrimaryKey
    @SerializedName("id")
    private Integer id;
    @SerializedName("artistName")
    private String artistName;
    @SerializedName("name")
    private String name;
    @SerializedName("artworkUrl100")
    private String imageLink;
    private boolean isFavourite = false;

    public AudiobookModel(Integer id, String artistName, String name, String imageLink, boolean isFavourite) {
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
