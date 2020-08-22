package com.stochanskyi.itunescharts.presentation.fragments.audiobooks.presentation;

import com.stochanskyi.itunescharts.data.network.featuresOld.audiobooks.models.AudiobookModel;
import com.stochanskyi.itunescharts.presentation.base.MVP.IBaseView;

import java.util.ArrayList;

public interface IAudiobooksView extends IBaseView {
    void updateData(ArrayList<AudiobookModel> model);
    void toAudiobookInfo(int id);
    void onRefreshFinished();
}
