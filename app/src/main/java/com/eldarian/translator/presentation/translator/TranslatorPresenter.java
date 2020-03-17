package com.eldarian.translator.presentation.translator;

import android.util.Log;

import androidx.annotation.NonNull;

import com.eldarian.translator.api.ShowcaseUseCase;
import com.eldarian.translator.app.types.Mapper;
import com.eldarian.translator.app.types.TranslateView;
import com.eldarian.translator.app.types.TranslateBase;
import com.eldarian.translator.presentation.threads.AddTranslateThread;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class TranslatorPresenter {

    private TranslatorView view;
    private ShowcaseUseCase showcaseUseCase;
    private Disposable translateDisposable;

    public TranslatorPresenter(ShowcaseUseCase showcaseUseCase){
        this.showcaseUseCase = showcaseUseCase;
    }

    public void getTranslate(@NonNull TranslateView translateView) {

        translateDisposable =  showcaseUseCase.getTranslate(Mapper.viewToQuery(translateView))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        textOut -> {
                            view.setTextOut(textOut);
                            TranslateBase translateBase = Mapper.viewResponseToBase(translateView, textOut);
                            new AddTranslateThread(translateBase);
                            },
                        throwable -> Log.d("EldarianLog", throwable.getMessage())
                );

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