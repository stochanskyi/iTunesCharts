package com.stochanskyi.itunescharts.presentation.baseOld;

import android.content.Context;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.stochanskyi.itunescharts.presentation.baseOld.MVP.BasePresenter;
import com.stochanskyi.itunescharts.presentation.baseOld.MVP.IBaseView;

public abstract class BaseFragment<P extends BasePresenter<V>, V extends IBaseView> extends Fragment
        implements IBaseView {
    protected P presenter;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        createPresenterInstance();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        view.setOnTouchListener((View v, MotionEvent event) -> true);
        initViews(view);
        initPresenter();
        presenter.onStart();
    }
}
