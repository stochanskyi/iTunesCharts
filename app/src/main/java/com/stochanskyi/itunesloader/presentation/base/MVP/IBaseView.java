package com.stochanskyi.itunesloader.presentation.base.MVP;

import android.view.View;

public interface IBaseView {
    void createPresenterInstance();
    void initPresenter();
    void initViews(View view);

}
