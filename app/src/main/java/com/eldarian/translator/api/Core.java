package com.eldarian.translator.api;

import com.eldarian.translator.app.AppData;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class Core {

    public static Core core;

    private Retrofit retrofit;
    private ShowcaseService showcaseService;

    private Core(){

        retrofit = new Retrofit.Builder()
                .baseUrl(AppData.API_URI)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        showcaseService = retrofit.create(ShowcaseService.class);
    }

    public static Core getCore(){
        if(core == null)
            core = new Core();
        return core;
    }

    public Retrofit getRetrofit(){
        return retrofit;
    }

    public ShowcaseService getShowcaseService() {
        return showcaseService;
    }
}
