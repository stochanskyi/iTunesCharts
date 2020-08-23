package com.stochanskyi.itunescharts.presentation.fragments.podcasts.presentation;

import com.stochanskyi.itunescharts.data.network.featuresOld.podcasts.models.PodcastModel;
import com.stochanskyi.itunescharts.presentation.baseOld.MVP.IBaseView;

import java.util.ArrayList;

public interface IPodcastsView extends IBaseView {
    void updateData(ArrayList<PodcastModel> data);
    void toPodcastInfo(int id);
    void onRefreshFinished();
}
