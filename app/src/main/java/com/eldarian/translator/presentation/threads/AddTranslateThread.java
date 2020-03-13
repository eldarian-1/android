package com.eldarian.translator.presentation.threads;

import com.eldarian.translator.app.App;
import com.eldarian.translator.database.TranslateBase;

public class AddTranslateThread implements Runnable {

    Thread thread;
    TranslateBase translateBase;

    public AddTranslateThread(TranslateBase translateBase){
        this.thread = new Thread(this, "AddTranslateThread");
        this.translateBase = translateBase;
        this.thread.start();
    }

    @Override
    public void run() {
        App.getInstance().getDatabase().translateDao().insert(translateBase);
    }

}
