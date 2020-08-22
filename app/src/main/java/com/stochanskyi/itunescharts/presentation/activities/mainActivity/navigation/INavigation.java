package com.stochanskyi.itunescharts.presentation.activities.mainActivity.navigation;

public interface INavigation {
    void toAudiobooks(boolean addToBackStack);
    void toMovies(boolean addToBackStack);
    void toPodcasts(boolean addToBackStack);
    void toFavourites(boolean addToBackStack);
}
