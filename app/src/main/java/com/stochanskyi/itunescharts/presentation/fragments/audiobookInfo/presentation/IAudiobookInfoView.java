package com.stochanskyi.itunescharts.presentation.fragments.audiobookInfo.presentation;

import com.stochanskyi.itunescharts.data.network.features.info.audiobookInfo.models.AudiobookInfoModel;
import com.stochanskyi.itunescharts.presentation.base.MVP.IBaseView;

public interface IAudiobookInfoView extends IBaseView {
    void setData(AudiobookInfoModel model);
}
