package com.eldarian.translator.entity;

import static com.eldarian.translator.app.AppData.API_URI;

public class Core {

    private static Core core;

    private Retrofit apiRetrofit;

    private ShowcaseService showcaseService;

    public Core(){

        apiRetrofit = new Retrofit.Builder()
                .baseUrl(API_URI)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        apiRetrofit.create(showcaseService.getClass());

    }

    public ShowcaseService getShowcaseService(){
        return showcaseService;
    }

    public static  Core instance(){
        if(core == null){
            core = new Core();
        }
        return core;
    }

}