package com.eldarian.translator.api;

import com.eldarian.translator.app.types.TranslateResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

import static com.eldarian.translator.app.AppData.API_KEY;

public interface ShowcaseService {

    @GET(value = "translate?key=" + API_KEY)
    Observable<TranslateResponse> getTranslate(@Query("lang") String lang, @Query("text") String text);

}