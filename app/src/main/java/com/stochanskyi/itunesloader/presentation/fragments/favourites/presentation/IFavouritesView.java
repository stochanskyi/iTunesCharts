package com.stochanskyi.itunesloader.presentation.fragments.favourites.presentation;

import com.stochanskyi.itunesloader.data.network.features.audiobooks.models.AudiobookModel;
import com.stochanskyi.itunesloader.data.network.features.movies.models.MovieModel;
import com.stochanskyi.itunesloader.data.network.features.podcasts.models.PodcastModel;
import com.stochanskyi.itunesloader.presentation.base.MVP.IBaseView;

import java.util.ArrayList;

public interface IFavouritesView extends IBaseView {
    void toAudiobookInfo(int id);
    void toMovieInfo(int id);
    void toPodcastInfo(int id);
    void updateData(ArrayList<AudiobookModel> audiobookModels, ArrayList<MovieModel> movieModels, ArrayList<PodcastModel> podcastModels);
}
