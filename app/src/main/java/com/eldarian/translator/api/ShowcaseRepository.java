package com.eldarian.translator.api;

import androidx.annotation.NonNull;

import com.eldarian.translator.app.types.TranslateQuery;
import com.eldarian.translator.app.types.TranslateResponse;

import io.reactivex.Observable;

public interface ShowcaseRepository {

    Observable<TranslateResponse> getTranslate(@NonNull final TranslateQuery translateQuery);

}