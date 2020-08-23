package com.stochanskyi.itunescharts.presentation.baseOld.MVP;

public interface IBasePresenter<V extends IBaseView> {
    void attachView(V view);
    void onStart();
    void release();
}
