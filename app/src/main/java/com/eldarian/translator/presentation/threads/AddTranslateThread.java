package com.eldarian.translator.presentation.threads;

import androidx.annotation.NonNull;

import com.eldarian.translator.app.App;
import com.eldarian.translator.app.types.TranslateBase;

public class AddTranslateThread implements Runnable {

    Thread thread;
    TranslateBase translateBase;

    public AddTranslateThread(@NonNull TranslateBase translateBase){
        this.thread = new Thread(this, "AddTranslateThread");
        this.translateBase = translateBase;
        this.thread.start();
    }

    @Override
    public void run() {
        App.getInstance().getDatabase().translateDao().insert(translateBase);
    }

}
