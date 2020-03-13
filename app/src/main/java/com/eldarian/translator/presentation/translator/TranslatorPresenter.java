package com.eldarian.translator.presentation.translator;

import com.eldarian.translator.api.TranslateResponse;
import com.eldarian.translator.api.YandexTranslateUseCase;
import com.eldarian.translator.app.TranslateView;
import com.eldarian.translator.database.TranslateBase;
import com.eldarian.translator.presentation.threads.AddTranslateThread;

import io.reactivex.functions.Consumer;

public class TranslatorPresenter {

    private TranslatorView view;

    public TranslatorPresenter(){}

    public void getTranslate(TranslateView translateView) {

        Consumer<TranslateResponse> consumerResponse = new Consumer<TranslateResponse>() {
            @Override
            public void accept(TranslateResponse item) throws Exception {
                setTextOut(item.text[0]);
            }
        };

        Consumer<TranslateBase> consumerBase = new Consumer<TranslateBase>() {
            @Override
            public void accept(TranslateBase item) throws Exception {
                addTranslateBase(item);
            }
        };

        YandexTranslateUseCase yandexQuery = new YandexTranslateUseCase();
        yandexQuery.translate(consumerResponse, consumerBase, translateView.getLangFrom() + "-" + translateView.getLangTo(), translateView.getTextIn());

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