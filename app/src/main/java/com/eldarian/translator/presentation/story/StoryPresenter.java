package com.eldarian.translator.presentation.story;

import android.util.Log;

import com.eldarian.translator.app.App;
import com.eldarian.translator.presentation.translator.TranslatorView;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.internal.observers.EmptyCompletableObserver;
import io.reactivex.schedulers.Schedulers;

public class StoryPresenter {

    private StoryView view;

    public StoryPresenter(StoryView view) {
        this.view = view;
    }

    void setTranslateList() {
        App.getInstance().getDatabase().translateDao().getAll()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnNext(data -> view.setTranslateList(data))
                .subscribe();
    }

    void clearTranslations() {
        App.getInstance().getDatabase().translateDao().dropData()
                .subscribeOn(Schedulers.io())
                .subscribe(new EmptyCompletableObserver());
    }
}