package com.eldarian.translator.entity.repository;

import android.database.Observable;

import com.eldarian.translator.entity.dto.ShowcaseCore;

import java.util.List;

public interface ShowcaseRepository {

    public Observable<List<ShowcaseCore>> all();

}
