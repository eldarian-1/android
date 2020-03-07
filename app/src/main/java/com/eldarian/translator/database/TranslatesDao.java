package com.eldarian.translator.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface TranslatesDao {

    @Query("SELECT * FROM translates")
    List<Translates> getAll();

    @Query("DELETE FROM translates")
    void dropData();

    @Insert
    void insert(Translates translate);

}