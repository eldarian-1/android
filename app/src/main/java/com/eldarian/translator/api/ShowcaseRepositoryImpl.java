package com.eldarian.translator.api;

import androidx.annotation.NonNull;

import com.eldarian.translator.app.types.TranslateQuery;
import com.eldarian.translator.app.types.TranslateResponse;

import io.reactivex.Observable;

public class ShowcaseRepositoryImpl implements ShowcaseRepository {

    private final ShowcaseService showcaseService;

    public ShowcaseRepositoryImpl(){
        showcaseService = Core.getCore().getShowcaseService();
    }

    @Override
    public Observable<TranslateResponse> getTranslate(@NonNull final TranslateQuery translateQuery) {
        return showcaseService.getTranslate(translateQuery.getLang(), translateQuery.getText());
    }

}