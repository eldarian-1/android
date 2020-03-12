package com.eldarian.translator.entity;

import android.database.Observable;

import com.eldarian.translator.entity.dto.ShowcaseCore;

import java.util.List;

public class ShowcaseService {

    @GET(value = "api/top")
    public Observable<List<ShowcaseCore>> getAllFilm();

}
