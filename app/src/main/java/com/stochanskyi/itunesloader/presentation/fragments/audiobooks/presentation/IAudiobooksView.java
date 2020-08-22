package com.stochanskyi.itunesloader.presentation.fragments.audiobooks.presentation;

import com.stochanskyi.itunesloader.data.network.features.audiobooks.models.AudiobookModel;
import com.stochanskyi.itunesloader.presentation.base.MVP.IBaseView;

import java.util.ArrayList;

public interface IAudiobooksView extends IBaseView {
    void updateData(ArrayList<AudiobookModel> model);
    void toAudiobookInfo(int id);
    void onRefreshFinished();
}
