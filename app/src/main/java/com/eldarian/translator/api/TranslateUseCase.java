package com.eldarian.translator.api;

import com.eldarian.translator.database.TranslateBase;

import io.reactivex.functions.Consumer;

public interface TranslateUseCase {

    void translate(Consumer<TranslateResponse> consumerResponse, Consumer<TranslateBase> consumerBase, final String lang, final String text);

}