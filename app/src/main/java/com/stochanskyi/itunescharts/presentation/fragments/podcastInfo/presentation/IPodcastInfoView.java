package com.stochanskyi.itunescharts.presentation.fragments.podcastInfo.presentation;

import com.stochanskyi.itunescharts.data.network.features.info.podcastInfo.models.PodcastInfoModel;
import com.stochanskyi.itunescharts.presentation.base.MVP.IBaseView;

public interface IPodcastInfoView extends IBaseView {
    void setData(PodcastInfoModel model);
}
