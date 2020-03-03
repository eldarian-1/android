package com.eldarian.translator.translator;

import android.content.Context;

import com.eldarian.translator.DataBase;
import com.eldarian.translator.Translations;

import java.util.ArrayList;
import java.util.List;

public class TranslatorModel {

    private DataBase db;

    TranslatorModel(Context context){
        db = new DataBase(context);
    }

    public void addTranslate(Translations translate){
        db.addTranslate(translate);
    }

}
