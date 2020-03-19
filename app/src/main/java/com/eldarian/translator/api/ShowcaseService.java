package com.eldarian.translator.api;

import com.eldarian.translator.app.AppData;
import com.eldarian.translator.app.types.TranslateResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ShowcaseService {

    @GET(value = "translate?key=trnsl.1.1.20200223T101151Z.f0b089fcc9cceaea.b8f54373181a5280fe6485a26d2e68a2e6475c92")
    Observable<TranslateResponse> getTranslate(@Query("lang") String lang, @Query("text") String text);

}