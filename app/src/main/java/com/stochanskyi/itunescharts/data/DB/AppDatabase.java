package com.stochanskyi.itunescharts.data.DB;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.stochanskyi.itunescharts.data.network.featuresOld.audiobooks.models.AudiobookModel;
import com.stochanskyi.itunescharts.data.network.featuresOld.movies.models.MovieModel;
import com.stochanskyi.itunescharts.data.network.featuresOld.podcasts.models.PodcastModel;

@Database(entities = {AudiobookModel.class, MovieModel.class, PodcastModel.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract DBDao dbDao();
}
