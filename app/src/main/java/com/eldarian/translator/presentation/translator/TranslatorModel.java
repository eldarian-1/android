package com.eldarian.translator.presentation.translator;

import android.content.Context;

import com.eldarian.translator.model.DataBase;
import com.eldarian.translator.model.Translations;

public class TranslatorModel {

    private DataBase db;

    TranslatorModel(Context context){
        db = new DataBase(context);
    }

    public void addTranslate(Translations translate){
        db.addTranslate(translate);
    }

}
