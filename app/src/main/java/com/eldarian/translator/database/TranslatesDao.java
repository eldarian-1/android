package com.eldarian.translator.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface TranslatesDao {

    @Query("SELECT * FROM translates")
    List<Translates> getAll();

    @Query("DROP TABLE IF EXISTS translates")
    void dropData();

    @Insert
    void insert(Translates translate);

    @Update
    void update(Translates translate);

    @Delete
    void delete(Translates translate);

}