package com.stochanskyi.itunescharts.presentation.fragments.favourites.presentation;

import com.stochanskyi.itunescharts.data.DBOld.DBClient;
import com.stochanskyi.itunescharts.data.network.featuresOld.audiobooks.models.AudiobookModel;
import com.stochanskyi.itunescharts.data.network.featuresOld.movies.models.MovieModel;
import com.stochanskyi.itunescharts.data.network.featuresOld.podcasts.models.PodcastModel;
import com.stochanskyi.itunescharts.presentation.baseOld.MVP.BasePresenter;

import java.util.ArrayList;

public class FavouritesPresenter extends BasePresenter<IFavouritesView> {

    ArrayList<AudiobookModel> audiobookModels;
    ArrayList<MovieModel> movieModels;
    ArrayList<PodcastModel> podcastModels;

    @Override
    public void onStart() {
        loadFromDB();
    }
    public void onAudiobookClick(int position) {
        view.toAudiobookInfo(audiobookModels.get(position).getId());
    }
    public void onMovieClick(int position) {
        view.toMovieInfo(movieModels.get(position).getId());
    }

    public void loadFromDB(){
        audiobookModels = new ArrayList<>(DBClient.getInstance().dbDao().getAllAudiobooks());
        movieModels = new ArrayList<>(DBClient.getInstance().dbDao().getAllMovies());
        podcastModels = new ArrayList<>(DBClient.getInstance().dbDao().getAllPodcasts());
        view.updateData(audiobookModels,movieModels,podcastModels);
    }
    public void onPodcastClick(int position) {
        view.toPodcastInfo(podcastModels.get(position).getId());
    }
    public void onAudiobookStarButtonUnliked(int position) {
        DBClient.getInstance().dbDao().deleteAudiobook(audiobookModels.get(position));
        audiobookModels.remove(position);
        view.updateData(audiobookModels,movieModels,podcastModels);
    }
    public void onMovieStarButtonUnliked(int position) {
        DBClient.getInstance().dbDao().deleteMovie(movieModels.get(position));
        movieModels.remove(position);
        view.updateData(audiobookModels,movieModels,podcastModels);
    }
    public void onPodcastStarButtonUnliked(int position) {
        DBClient.getInstance().dbDao().deletePodcast(podcastModels.get(position));
        podcastModels.remove(position);
        view.updateData(audiobookModels,movieModels,podcastModels);
    }
}
