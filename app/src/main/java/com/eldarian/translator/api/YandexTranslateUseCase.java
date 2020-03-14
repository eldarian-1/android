package com.eldarian.translator.api;

import android.util.Log;

import androidx.annotation.NonNull;

import com.eldarian.translator.app.types.Mapper;
import com.eldarian.translator.app.types.TranslateBase;
import com.eldarian.translator.app.types.TranslateQuery;
import com.eldarian.translator.app.types.TranslateResponse;

import io.reactivex.functions.Consumer;
import io.reactivex.Observable;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class YandexTranslateUseCase implements TranslateUseCase {

    private Core core;
    private Retrofit retrofit;
    private TranslateApi translateApi;

    public YandexTranslateUseCase(){
        core = Core.getCore();
        retrofit = core.getRetrofit();
        translateApi = core.getTranslateApi();
    }

    @Override
    public void translate(@NonNull Consumer<TranslateResponse> consumerResponse,
                          @NonNull Consumer<TranslateBase> consumerBase, @NonNull final TranslateQuery translateQuery) {

        Call<TranslateResponse> translateResponseCall = translateApi.getTranslate(
                translateQuery.getLang(), translateQuery.getText());

        translateResponseCall.enqueue(new Callback<TranslateResponse>() {

            @Override
            public void onResponse(Call<TranslateResponse> call, Response<TranslateResponse> response) {

                TranslateResponse translateResponse = response.body();
                if(translateResponse != null) {

                    TranslateBase translateBase = Mapper.queryResponseToBase(translateQuery, translateResponse);

                    Observable<TranslateResponse> translateResponseObservable = Observable.just(translateResponse);
                    translateResponseObservable.subscribe(consumerResponse).dispose();

                    Observable<TranslateBase> translateBaseObservable = Observable.just(translateBase);
                    translateBaseObservable.subscribe(consumerBase).dispose();

                } else {
                    Log.d("EldarianLog", response.toString());
                }
            }

            @Override
            public void onFailure(Call<TranslateResponse> call, Throwable t) {
                Log.d("EldarianLog", "failture " + t);
            }
        });

    }

}