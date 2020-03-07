package com.eldarian.translator.app;

import android.app.Application;

import androidx.room.Room;

import com.eldarian.translator.database.AppDataBase;

public class App extends Application {

    public static App instance;
    private AppDataBase database;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        database = Room.databaseBuilder(this, AppDataBase.class, "appdata")
                .allowMainThreadQueries()
                .build();
    }

    public static App getInstance() {
        return instance;
    }

    public AppDataBase getDatabase() {
        return database;
    }


}