package com.eldarian.translator.app.types;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class TranslateBase {

    @PrimaryKey(autoGenerate = true)
    public long id;
    public String lang;
    public String textIn;
    public String textOut;

}