package com.stochanskyi.itunescharts.presentation.fragments.movieInfo.presentation;

import com.stochanskyi.itunescharts.data.network.featuresOld.info.movieInfo.models.MovieInfoModel;
import com.stochanskyi.itunescharts.presentation.baseOld.MVP.IBaseView;

public interface IMovieInfoView extends IBaseView {
    void setData(MovieInfoModel model);
}
