package com.eldarian.translator.api;

import com.eldarian.translator.app.AppData;
import com.eldarian.translator.app.types.TranslateResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface TranslateApi {

    @GET("translate?key=" + AppData.API_KEY)
    Call<TranslateResponse> getTranslate(@Query("lang") String lang, @Query("text") String text);

}