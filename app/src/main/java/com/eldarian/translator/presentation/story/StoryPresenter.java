package com.eldarian.translator.presentation.story;

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