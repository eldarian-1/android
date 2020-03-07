package com.eldarian.translator.database;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Translates {

    @PrimaryKey
    public long id;
    public String langIn;
    public String langOut;
    public String textIn;
    public String textOut;

}
