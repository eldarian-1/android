package com.eldarian.translator.presentation.story;

import android.content.Context;
import com.eldarian.translator.model.DataBase;
import com.eldarian.translator.model.Translations;

import java.util.List;

public class StoryModel {

    private DataBase db;

    StoryModel(Context context){
        db = new DataBase(context);
    }

    public List<Translations> getTranslationsList(){
        return db.getTranslationsList();
    }
    public void clearTranslations(Context context){
        db.clearTranslations(context);
    }

}
