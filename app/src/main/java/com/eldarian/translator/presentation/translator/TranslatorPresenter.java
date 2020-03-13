package com.eldarian.translator.presentation.translator;

import com.eldarian.translator.app.TranslateView;
import com.eldarian.translator.database.TranslateBase;
import com.eldarian.translator.presentation.threads.AddTranslateThread;
import com.eldarian.translator.presentation.threads.TranslatorThread;

public class TranslatorPresenter {

    private TranslatorView view;

    public TranslatorPresenter(){}

    public void getTranslate(TranslateView translateView) {
        new TranslatorThread(translateView, this);
    }

    public void addTranslateBase(TranslateBase translateBase){
        new AddTranslateThread(translateBase);
    }

    public void setTextOut(String text){
        view.setTextOut(text);
    }

    public void clearField() {
        view.setLangFrom(0);
        view.setLangTo(0);
        view.setTextIn("");
        view.setTextOut("");
    }

    public void attachView(TranslatorView view) {
        this.view = view;
    }
    public void detachView() {
        view = null;
    }
    public void viewIsReady() {}

}