package com.eldarian.translator.story;

import android.content.Context;
import com.eldarian.translator.DataBase;
import com.eldarian.translator.Translations;

import java.util.ArrayList;
import java.util.List;

public class StoryModel {

    private DataBase db;

    StoryModel(Context context){
        db = new DataBase(context);
    }

    public ArrayList<Translations> getTranslationsList(){
        return db.getTranslationsList();
    }
    public void clearTranslations(Context context){
        db.clearTranslations(context);
    }

}
