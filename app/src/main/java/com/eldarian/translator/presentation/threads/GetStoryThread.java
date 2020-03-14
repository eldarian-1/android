package com.eldarian.translator.presentation.threads;

import androidx.annotation.NonNull;

import com.eldarian.translator.app.App;
import com.eldarian.translator.presentation.story.StoryView;

import java.util.List;

public class GetStoryThread implements Runnable {

    private Thread thread;
    private StoryView view;

    public GetStoryThread(@NonNull StoryView view){
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
