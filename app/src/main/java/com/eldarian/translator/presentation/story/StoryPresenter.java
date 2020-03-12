package com.eldarian.translator.presentation.story;

import com.eldarian.translator.presentation.threads.DeleteStoryThread;
import com.eldarian.translator.presentation.threads.GetStoryThread;

public class StoryPresenter {

    private StoryView view;

    public StoryPresenter(){}

    public void setTranslateList() {
        new GetStoryThread(view);
    }

    void clearTranslations() {
        new DeleteStoryThread();
    }

    void attachView(StoryView view) {
        this.view = view;
    }
    public void detachView() {
        view = null;
    }
    void viewIsReady() {}

}