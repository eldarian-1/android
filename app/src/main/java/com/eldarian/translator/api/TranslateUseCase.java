package com.eldarian.translator.api;

import androidx.annotation.NonNull;

import com.eldarian.translator.app.types.TranslateBase;
import com.eldarian.translator.app.types.TranslateQuery;
import com.eldarian.translator.app.types.TranslateResponse;

import io.reactivex.functions.Consumer;

public interface TranslateUseCase {

    void translate(@NonNull Consumer<TranslateResponse> consumerResponse,
                   @NonNull Consumer<TranslateBase> consumerBase, @NonNull final TranslateQuery translateQuery);

}