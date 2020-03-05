package com.eldarian.translator.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Translate.class}, version = 1)
public abstract class AppDataBase extends RoomDatabase {

    public abstract TranslateDao employeeDao();

}