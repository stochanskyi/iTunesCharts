package com.stochanskyi.itunesloader.presentation.fragments.podcasts.presentation;

import com.stochanskyi.itunesloader.data.network.features.podcasts.models.PodcastModel;
import com.stochanskyi.itunesloader.presentation.base.MVP.IBaseView;

import java.util.ArrayList;

public interface IPodcastsView extends IBaseView {
    void updateData(ArrayList<PodcastModel> data);
    void toPodcastInfo(int id);
    void onRefreshFinished();
}
