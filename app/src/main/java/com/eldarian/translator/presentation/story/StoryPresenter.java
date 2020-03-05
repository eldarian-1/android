package com.eldarian.translator.presentation.story;

import android.content.Context;

import androidx.appcompat.app.AppCompatActivity;

import com.eldarian.translator.model.Translations;

import java.util.List;

public class StoryPresenter extends AppCompatActivity {

    private StoryView view;
    private StoryModel model;

    StoryPresenter(StoryModel model){
        this.model = model;
    }
    public void attachView(StoryView view) {
        view = view;
    }
    public void detachView() {
        view = null;
    }
    public void viewIsReady() {}

    public List<Translations> getTranslationsList()
    {
        return model.getTranslationsList();
    }
    public void clearTranslations(Context context){
        model.clearTranslations(context);
    }

}