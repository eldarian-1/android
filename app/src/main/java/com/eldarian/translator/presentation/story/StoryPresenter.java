package com.eldarian.translator.presentation.story;

import android.content.Context;

import androidx.appcompat.app.AppCompatActivity;

import com.eldarian.translator.model.Translations;

import java.util.List;

public class StoryPresenter {

    private StoryView view;
    private StoryModel model;

    StoryPresenter(StoryModel model) {
        this.model = model;
    }

    void attachView(StoryView view) {
        this.view = view;
    }

    public void detachView() {
        view = null;
    }

    void viewIsReady() {
    }

    List<Translations> getTranslationsList() {
        return model.getTranslationsList();
    }

    void clearTranslations(Context context) {
        model.clearTranslations(context);
    }

}