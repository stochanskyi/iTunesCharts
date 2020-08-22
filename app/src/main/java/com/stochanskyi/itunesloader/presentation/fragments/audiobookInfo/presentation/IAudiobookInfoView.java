package com.stochanskyi.itunesloader.presentation.fragments.audiobookInfo.presentation;

import com.stochanskyi.itunesloader.data.network.features.info.audiobookInfo.models.AudiobookInfoModel;
import com.stochanskyi.itunesloader.presentation.base.MVP.IBaseView;

public interface IAudiobookInfoView extends IBaseView {
    void setData(AudiobookInfoModel model);
}
