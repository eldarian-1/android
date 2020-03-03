package com.eldarian.translator;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import static com.eldarian.translator.story.StoryView.DataApp.CREATE_DB;

public class DataBase {

    private SQLiteDatabase db;

    public DataBase(Context context){
        db = context.openOrCreateDatabase("app.db", context.MODE_PRIVATE, null);
        db.execSQL(CREATE_DB);
    }

    public void addTranslate(Translations translate){
        System.out.println("Hello pacani!");
        String quer = "INSERT INTO translations (langIn, langOut, textIn, textOut) VALUES (\"" + translate.getLangIn() + "\", \""
                + translate.getLangOut() +"\", \"" + translate.getTextIn() + "\", \"" + translate.getTextOut() + "\");";
        System.out.println(quer);
        db.execSQL(quer);
        db.close();
    }

    public ArrayList<Translations> getTranslationsList(){
        Translations translate;
        ArrayList<Translations> translations = new ArrayList<Translations>();
        Cursor query = db.rawQuery("SELECT * FROM translations;", null);
        if(query.moveToFirst()){
            do{
                translate = new Translations(query.getString(1), query.getString(2), query.getString(3), query.getString(4));
                translations.add(translate);
            }
            while(query.moveToNext());
        }
        query.close();
        db.close();
        return translations;
    }

    public void clearTranslations(Context context){
        System.out.println("DROP TABLE IF EXISTS translations;");
        if(!db.isOpen())
            db = context.openOrCreateDatabase("app.db", context.MODE_PRIVATE, null);
        db.execSQL("DROP TABLE IF EXISTS translations;");
        db.close();
    }

}
