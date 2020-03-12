package com.eldarian.translator.presentation.story;

import com.eldarian.translator.app.App;

import java.util.List;

public class GetStoryThread implements Runnable {

    private Thread thread;
    private StoryView view;

    GetStoryThread(StoryView view){
        this.thread = new Thread(this, "story");
        this.view = view;
        this.thread.start();
    }

    @Override
    public void run() {
        App instance = App.getInstance();
        List list = instance.getDatabase().translateDao().getAll();
        view.setTranslateList(list);
    }

}
