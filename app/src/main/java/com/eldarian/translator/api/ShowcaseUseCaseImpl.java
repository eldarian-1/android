package com.eldarian.translator.api;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.eldarian.translator.app.types.TranslateQuery;
import com.eldarian.translator.app.types.TranslateResponse;

import java.util.List;

import io.reactivex.Observable;

public class ShowcaseUseCaseImpl implements ShowcaseUseCase {

    private final ShowcaseRepository repository;

    private static final String DEFAULT_MAPPER_RESULT = "";

    public ShowcaseUseCaseImpl(ShowcaseRepository repository) {
        this.repository = repository;
    }

    @Override
    public Observable<String> getTranslate(@NonNull final TranslateQuery translateQuery) {
        return repository.getTranslate(translateQuery).map(this::map);
    }

    private String map(TranslateResponse item) {
        List<String> text = item.text();
        if (text != null && text.size() > 0) {
            return text.get(0);
        }
        return DEFAULT_MAPPER_RESULT;
    }
}
