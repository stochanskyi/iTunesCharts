package com.stochanskyi.itunescharts.presentation.fragments.movies.presentation;

import com.stochanskyi.itunescharts.data.network.featuresOld.movies.models.MovieModel;
import com.stochanskyi.itunescharts.presentation.baseOld.MVP.IBaseView;

import java.util.ArrayList;

public interface IMoviesView extends IBaseView {
    void updateData(ArrayList<MovieModel> movies);
    void toMovieInfo(int id);
    void onRefreshFinished();
}
