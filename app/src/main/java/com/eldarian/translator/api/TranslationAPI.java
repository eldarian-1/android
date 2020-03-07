package com.eldarian.translator.api;

import java.util.Map;

import retrofit2.Callback;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface TranslationAPI {

    @GET("translate")
    Callback<Translation> getTranslate(@QueryMap Map<String, String> params, Callback<String> callback);

}