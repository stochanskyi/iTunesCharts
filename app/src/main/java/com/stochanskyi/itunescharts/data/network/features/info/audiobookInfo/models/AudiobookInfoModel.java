package com.stochanskyi.itunescharts.data.network.features.info.audiobookInfo.models;

import com.google.gson.annotations.SerializedName;

public class AudiobookInfoModel {
    @SerializedName("collectionName")
    private String name;
    @SerializedName("artistName")
    private String artistName;
    @SerializedName("artworkUrl100")
    private String imageLink;
    @SerializedName("collectionPrice")
    private Float price;
    @SerializedName("country")
    private String country;
    @SerializedName("description")
    private String description;

    public AudiobookInfoModel(String name, String artistName, String imageLink, Float price, String country, String description) {
        this.name = name;
        this.artistName = artistName;
        this.imageLink = imageLink;
        this.price = price;
        this.country = country;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getArtistName() {
        return artistName;
    }

    public String getImageLink() {
        return imageLink;
    }

    public Float getPrice() {
        return price;
    }

    public String getCountry() {
        return country;
    }

    public String getDescription() {
        return description;
    }
}
