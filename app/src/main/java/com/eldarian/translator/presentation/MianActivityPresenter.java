package com.eldarian.translator.presentation;

import com.arellomobile.*;
import com.arellomobile.mvp.*;

@InjectViewState
public class MainActivityPresenter extends MvpPresenter<MainView> {
    public MainActivityPresenter() {
        getViewState().showMessage(R.string.hello_world);
    }
}