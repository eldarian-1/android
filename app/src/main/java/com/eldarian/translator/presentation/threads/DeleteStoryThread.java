package com.eldarian.translator.presentation.threads;

import com.eldarian.translator.app.App;

public class DeleteStoryThread implements Runnable {

    private Thread thread;

    public DeleteStoryThread(){
        this.thread = new Thread(this, "DeleteStoryThread");
        this.thread.start();
    }

    @Override
    public void run() {
        App instance = App.getInstance();
        instance.getDatabase().translateDao().dropData();
    }

}
