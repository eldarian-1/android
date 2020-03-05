package com.eldarian.translator.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface TranslateDao {

    @Query("SELECT * FROM db")
    List<Translate> getAll();

    @Query("SELECT * FROM db WHERE id = :id")
    Translate getById(long id);

    @Insert
    void insert(Translate translate);

    @Update
    void update(Translate translate);

    @Delete
    void delete(Translate translate);

}