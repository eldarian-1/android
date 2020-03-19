package com.eldarian.translator.presentation.translator;

import androidx.annotation.NonNull;

import com.eldarian.translator.app.types.TranslateView;

public interface TranslatorView {

    void init();

    void clearFields();
    void setTextOut(String text);

    @NonNull
    TranslateView getTranslateView();

}