package com.eldarian.translator.entity.repository;

import android.database.Observable;

import com.eldarian.translator.entity.Core;
import com.eldarian.translator.entity.ShowcaseService;
import com.eldarian.translator.entity.dto.ShowcaseCore;

import java.util.List;

public class ShowcaseRepositoryImpl implements ShowcaseRepository {

    private ShowcaseService showcaseService;

    public ShowcaseRepositoryImpl() {
        this.showcaseService = Core.instance().getShowcaseService();
    }

    @Override
    public Observable<List<ShowcaseCore>> all() {
        return showcaseService.getAllFilm();
    }

}
