package com.eldarian.translator.api;

import com.eldarian.translator.presentation.translator.TranslatorPresenter;

import java.util.Map;

public interface TranslateUseCase {

    void translate(final TranslatorPresenter presenter, Map<String, String> mapper);

}