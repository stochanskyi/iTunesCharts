package com.stochanskyi.itunesloader.data.DB;

import androidx.room.Dao;
import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.stochanskyi.itunesloader.data.network.features.audiobooks.models.AudiobookModel;
import com.stochanskyi.itunesloader.data.network.features.movies.models.MovieModel;
import com.stochanskyi.itunesloader.data.network.features.podcasts.models.PodcastModel;

@Database(entities = {AudiobookModel.class, MovieModel.class, PodcastModel.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract DBDao dbDao();
}
