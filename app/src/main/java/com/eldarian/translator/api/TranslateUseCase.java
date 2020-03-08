package com.eldarian.translator.api;

import com.eldarian.translator.presentation.translator.TranslatorPresenter;

public interface TranslateUseCase {

    void translate(final TranslatorPresenter presenter, final String lang, final String text);

}