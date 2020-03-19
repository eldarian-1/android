package com.eldarian.translator.api;

import com.eldarian.translator.app.AppData;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

class Core {

    private static Core core;
    private final ShowcaseService showcaseService;

    private Core() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(AppData.API_URI)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        showcaseService = retrofit.create(ShowcaseService.class);
    }

    static Core getCore() {
        if (core == null)
            core = new Core();
        return core;
    }

    ShowcaseService getShowcaseService() {
        return showcaseService;
    }
}
