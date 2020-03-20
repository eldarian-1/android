package com.eldarian.translator.database;

import androidx.annotation.NonNull;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.eldarian.translator.app.types.TranslateBase;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Observable;

@Dao
public interface TranslateBaseDao {

    @NonNull
    @Query("SELECT * FROM translatebase")
    Observable<List<TranslateBase>> getAll();

    @Query("DELETE FROM translatebase")
    Completable dropData();

    @Insert
    Completable insert(TranslateBase translateBase);

}