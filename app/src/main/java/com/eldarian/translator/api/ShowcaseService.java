package com.eldarian.translator.api;

import androidx.annotation.NonNull;

import com.eldarian.translator.app.AppData;
import com.eldarian.translator.app.types.TranslateResponse;


import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ShowcaseService {

    @NonNull
    @GET(value = "translate?key=" + AppData.API_KEY)
    Observable<TranslateResponse> getTranslate(@Query("lang") String lang, @Query("text") String text);

}