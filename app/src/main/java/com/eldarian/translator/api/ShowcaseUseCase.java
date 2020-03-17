package com.eldarian.translator.api;

import androidx.annotation.NonNull;

import com.eldarian.translator.app.types.TranslateQuery;

import io.reactivex.Observable;

public interface ShowcaseUseCase {

    Observable<String> getTranslate(@NonNull final TranslateQuery translateQuery);

}
