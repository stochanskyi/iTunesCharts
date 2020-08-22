package com.stochanskyi.itunesloader.presentation.fragments.podcastInfo.presentation;

import com.stochanskyi.itunesloader.data.network.features.info.podcastInfo.models.PodcastInfoModel;
import com.stochanskyi.itunesloader.presentation.base.MVP.IBaseView;

public interface IPodcastInfoView extends IBaseView {
    void setData(PodcastInfoModel model);
}
