package com.eldarian.translator.story;

import androidx.appcompat.app.AppCompatActivity;

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


    public void viewIsReady() {
        //loadUsers();
    }

}