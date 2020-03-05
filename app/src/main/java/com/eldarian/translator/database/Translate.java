package com.eldarian.translator.database;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Translate {

    @PrimaryKey
    public long id;
    public String langIn;
    public String langOut;
    public String textIn;
    public String textOut;

}
