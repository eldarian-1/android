package com.eldarian.translator.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.eldarian.translator.app.types.TranslateBase;

import java.util.List;

@Dao
public interface TranslateBaseDao {

    @Query("SELECT * FROM translatebase")
    List<TranslateBase> getAll();

    @Query("DELETE FROM translatebase")
    void dropData();

    @Insert
    void insert(TranslateBase translateBase);

}