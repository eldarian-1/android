package com.eldarian.translator.presentation.story;

import com.eldarian.translator.app.App;

import java.util.List;

public class StoryPresenter {

    private StoryView view;

    public StoryPresenter(){}

    List getTranslateList() {
        App instance = App.getInstance();
        return instance.getDatabase().translateDao().getAll();
    }

    void clearTranslations() {
        App instance = App.getInstance();
        instance.getDatabase().translateDao().dropData();
    }

    void attachView(StoryView view) {
        this.view = view;
    }
    public void detachView() {
        view = null;
    }
    void viewIsReady() {}

}