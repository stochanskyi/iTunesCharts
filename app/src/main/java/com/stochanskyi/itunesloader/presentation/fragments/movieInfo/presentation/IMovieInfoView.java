package com.stochanskyi.itunesloader.presentation.fragments.movieInfo.presentation;

import com.stochanskyi.itunesloader.data.network.features.info.movieInfo.models.MovieInfoModel;
import com.stochanskyi.itunesloader.presentation.base.MVP.IBaseView;

public interface IMovieInfoView extends IBaseView {
    void setData(MovieInfoModel model);
}
