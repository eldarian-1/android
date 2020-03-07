package com.eldarian.translator.api;

import android.util.Log;

import com.eldarian.translator.app.AppData;
import com.eldarian.translator.presentation.translator.TranslatorPresenter;

import org.json.JSONException;

import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class YandexTranslateUseCase implements TranslateUseCase {

    @Override
    public void translate(final TranslatorPresenter presenter, Map<String, String> mapper) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(AppData.API_URI)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        TranslationAPI translationApi = retrofit.create(TranslationAPI.class);

        translationApi.getTranslate(mapper, new Callback<String>() {

            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Log.d("Response", "Response " + response.body());
                try {
                    presenter.setTextOut(response.body());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.d("Response", "failure " + t);
            }

        });
    }

}
