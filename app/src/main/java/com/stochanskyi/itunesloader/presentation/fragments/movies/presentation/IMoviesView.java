package com.stochanskyi.itunesloader.presentation.fragments.movies.presentation;

import com.stochanskyi.itunesloader.data.network.features.movies.models.MovieModel;
import com.stochanskyi.itunesloader.presentation.base.MVP.IBaseView;

import java.util.ArrayList;

public interface IMoviesView extends IBaseView {
    void updateData(ArrayList<MovieModel> movies);
    void toMovieInfo(int id);
    void onRefreshFinished();
}
