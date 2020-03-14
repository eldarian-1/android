package com.eldarian.translator.api;

import com.eldarian.translator.app.AppData;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Core {

    public static Core core;

    private Retrofit retrofit;
    private TranslateApi translateApi;

    private Core(){

        retrofit = new Retrofit.Builder()
                .baseUrl(AppData.API_URI)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        translateApi = retrofit.create(TranslateApi.class);
    }

    public static Core getCore(){
        if(core == null)
            core = new Core();
        return core;
    }

    public Retrofit getRetrofit(){
        return retrofit;
    }

    public TranslateApi getTranslateApi() {
        return translateApi;
    }
}
