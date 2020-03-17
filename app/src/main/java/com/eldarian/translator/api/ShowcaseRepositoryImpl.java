package com.eldarian.translator.api;

import androidx.annotation.NonNull;

import com.eldarian.translator.app.types.TranslateQuery;
import com.eldarian.translator.app.types.TranslateResponse;

import io.reactivex.Observable;

import retrofit2.Retrofit;

public class ShowcaseRepositoryImpl implements ShowcaseRepository {

    private Core core;
    private Retrofit retrofit;
    private ShowcaseService showcaseService;

    public ShowcaseRepositoryImpl(){
        core = Core.getCore();
        retrofit = core.getRetrofit();
        showcaseService = core.getShowcaseService();
    }

    @Override
    public Observable<TranslateResponse> getTranslate(@NonNull final TranslateQuery translateQuery) {
        return showcaseService.getTranslate(translateQuery.getLang(), translateQuery.getText());
    }

}