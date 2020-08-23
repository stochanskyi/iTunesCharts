package com.stochanskyi.itunescharts.presentation.activities.mainActivity.presentation;

import com.stochanskyi.itunescharts.presentation.baseOld.MVP.BasePresenter;

public class MainActivityPresenter extends BasePresenter<IMainActivityView> {

    @Override
    public void onStart() {

    }
    public void onMovieButtonClicked() {
        view.toMovies(true);
    }
    public void onAudiobooksClicked(){
        view.toAudiobooks(true);
    }
    public void onPodcastsClicked(){
        view.toPodcasts(true);
    }
    public void onFavouritesClicked() {
        view.toFavourites(true);
    }
}
