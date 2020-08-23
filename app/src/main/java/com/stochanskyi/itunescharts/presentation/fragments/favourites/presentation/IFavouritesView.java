package com.stochanskyi.itunescharts.presentation.fragments.favourites.presentation;

import com.stochanskyi.itunescharts.data.network.featuresOld.audiobooks.models.AudiobookModel;
import com.stochanskyi.itunescharts.data.network.featuresOld.movies.models.MovieModel;
import com.stochanskyi.itunescharts.data.network.featuresOld.podcasts.models.PodcastModel;
import com.stochanskyi.itunescharts.presentation.baseOld.MVP.IBaseView;

import java.util.ArrayList;

public interface IFavouritesView extends IBaseView {
    void toAudiobookInfo(int id);
    void toMovieInfo(int id);
    void toPodcastInfo(int id);
    void updateData(ArrayList<AudiobookModel> audiobookModels, ArrayList<MovieModel> movieModels, ArrayList<PodcastModel> podcastModels);
}
