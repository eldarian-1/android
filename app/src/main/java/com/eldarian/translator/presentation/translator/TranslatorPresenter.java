package com.eldarian.translator.presentation.translator;

import androidx.annotation.NonNull;

import com.eldarian.translator.api.ShowcaseRepositoryImpl;
import com.eldarian.translator.api.ShowcaseUseCase;
import com.eldarian.translator.api.ShowcaseUseCaseImpl;
import com.eldarian.translator.app.App;
import com.eldarian.translator.app.types.Mapper;
import com.eldarian.translator.app.types.TranslateView;
import com.eldarian.translator.presentation.story.StoryView;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.internal.observers.EmptyCompletableObserver;
import io.reactivex.schedulers.Schedulers;

public class TranslatorPresenter {

    private TranslatorView view;

    public TranslatorPresenter(TranslatorView view) {
        this.view = view;
    }

    public void getTranslate(@NonNull TranslateView translateView) {

        ShowcaseUseCase showcaseUseCase = new ShowcaseUseCaseImpl(new ShowcaseRepositoryImpl());

        showcaseUseCase.getTranslate(Mapper.viewToQuery(translateView))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnNext(textOut -> view.setTextOut(textOut))
                .observeOn(Schedulers.io())
                .map(textOut -> Mapper.viewResponseToBase(translateView, textOut))
                .flatMapCompletable(translateBase -> App.getInstance().getDatabase().translateDao().insert(translateBase))
                .subscribe(new EmptyCompletableObserver());
    }
}