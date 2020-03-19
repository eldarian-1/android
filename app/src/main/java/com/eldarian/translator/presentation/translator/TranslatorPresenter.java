package com.eldarian.translator.presentation.translator;

import androidx.annotation.NonNull;

import com.eldarian.translator.api.ShowcaseUseCase;
import com.eldarian.translator.app.App;
import com.eldarian.translator.app.types.Mapper;
import com.eldarian.translator.app.types.TranslateView;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.internal.observers.EmptyCompletableObserver;
import io.reactivex.schedulers.Schedulers;

public class TranslatorPresenter {

    private TranslatorView view;
    private ShowcaseUseCase showcaseUseCase;

    public TranslatorPresenter(ShowcaseUseCase showcaseUseCase) {
        this.showcaseUseCase = showcaseUseCase;
    }

    public void getTranslate(@NonNull TranslateView translateView) {
        showcaseUseCase.getTranslate(Mapper.viewToQuery(translateView))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnNext(textOut -> view.setTextOut(textOut))
                .observeOn(Schedulers.io())
                .map(textOut -> Mapper.viewResponseToBase(translateView, textOut))
                .flatMapCompletable(translateBase -> App.getInstance().getDatabase().translateDao().insert(translateBase))
                .subscribe(new EmptyCompletableObserver());
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

    public void viewIsReady() {
    }
}