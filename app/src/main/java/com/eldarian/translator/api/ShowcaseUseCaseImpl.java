package com.eldarian.translator.api;

import androidx.annotation.NonNull;

import com.eldarian.translator.app.types.TranslateQuery;
import com.eldarian.translator.app.types.TranslateResponse;

import io.reactivex.Observable;

public class ShowcaseUseCaseImpl implements ShowcaseUseCase {

    private final ShowcaseRepository repository;

    public ShowcaseUseCaseImpl(ShowcaseRepository repository) {
        this.repository = repository;
    }

    @Override
    public Observable<String> getTranslate(@NonNull final TranslateQuery translateQuery) {
        return repository.getTranslate(translateQuery).map(this::map);
    }

    private String map(TranslateResponse item) {
        return item.text.get(0);
    }
}
