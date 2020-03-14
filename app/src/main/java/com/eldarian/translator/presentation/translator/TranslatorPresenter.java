package com.eldarian.translator.presentation.translator;

import androidx.annotation.NonNull;

import com.eldarian.translator.app.types.Mapper;
import com.eldarian.translator.app.types.TranslateQuery;
import com.eldarian.translator.app.types.TranslateResponse;
import com.eldarian.translator.api.YandexTranslateUseCase;
import com.eldarian.translator.app.types.TranslateView;
import com.eldarian.translator.app.types.TranslateBase;
import com.eldarian.translator.presentation.threads.AddTranslateThread;

import io.reactivex.functions.Consumer;

public class TranslatorPresenter {

    private TranslatorView view;

    public TranslatorPresenter(){}

    public void getTranslate(@NonNull TranslateView translateView) {

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
        TranslateQuery translateQuery = Mapper.viewToQuery(translateView);
        yandexQuery.translate(consumerResponse, consumerBase, translateQuery);

    }

    public void addTranslateBase(@NonNull TranslateBase translateBase){
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