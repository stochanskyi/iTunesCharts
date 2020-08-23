package com.stochanskyi.itunescharts.presentation.baseOld.MVP;

public abstract class BasePresenter<V extends IBaseView> implements IBasePresenter<V> {
    protected V view;

    @Override
    public void attachView(V view) {
        this.view=view;
    }

    @Override
    public void release() {
        this.view = null;
    }
}
