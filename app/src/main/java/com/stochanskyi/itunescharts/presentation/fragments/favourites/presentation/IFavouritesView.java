package com.stochanskyi.itunescharts.presentation.fragments.favourites.presentation;

import com.stochanskyi.itunescharts.data.network.features.audiobooks.models.AudiobookModel;
import com.stochanskyi.itunescharts.data.network.features.movies.models.MovieModel;
import com.stochanskyi.itunescharts.data.network.features.podcasts.models.PodcastModel;
import com.stochanskyi.itunescharts.presentation.base.MVP.IBaseView;

import java.util.ArrayList;

public interface IFavouritesView extends IBaseView {
    void toAudiobookInfo(int id);
    void toMovieInfo(int id);
    void toPodcastInfo(int id);
    void updateData(ArrayList<AudiobookModel> audiobookModels, ArrayList<MovieModel> movieModels, ArrayList<PodcastModel> podcastModels);
}
