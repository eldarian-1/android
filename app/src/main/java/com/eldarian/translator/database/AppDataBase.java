package com.eldarian.translator.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.eldarian.translator.app.types.TranslateBase;

@Database(entities = {TranslateBase.class}, version = 1)
public abstract class AppDataBase extends RoomDatabase {

    public abstract TranslateBaseDao translateDao();

}