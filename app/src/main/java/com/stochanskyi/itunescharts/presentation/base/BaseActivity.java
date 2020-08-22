package com.stochanskyi.itunescharts.presentation.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.stochanskyi.itunescharts.presentation.base.MVP.BasePresenter;
import com.stochanskyi.itunescharts.presentation.base.MVP.IBaseView;

public abstract class BaseActivity<P extends BasePresenter<V>, V extends IBaseView> extends AppCompatActivity
        implements IBaseView {

    protected P presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        createPresenterInstance();
        initPresenter();
    }
}
