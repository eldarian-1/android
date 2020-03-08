package com.eldarian.translator.presentation.translator;

import com.eldarian.translator.app.App;
import com.eldarian.translator.app.TranslateView;
import com.eldarian.translator.api.YandexTranslateUseCase;
import com.eldarian.translator.database.TranslateBase;

public class TranslatorPresenter {

    private TranslatorView view;

    public TranslatorPresenter(){}

    public void getTranslate(TranslateView translateView){
        YandexTranslateUseCase yandexQuery = new YandexTranslateUseCase();
        yandexQuery.translate(this,translateView.getLangFrom() + "-" + translateView.getLangTo(), translateView.getTextIn());
    }

    public void addTranslateBase(TranslateBase translateBase){
        App.getInstance().getDatabase().translateDao().insert(translateBase);
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