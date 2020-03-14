package com.eldarian.translator.presentation.translator;

import androidx.annotation.NonNull;

import com.eldarian.translator.app.types.TranslateView;

public interface TranslatorView {

    void init();

    void setLangFrom(int position);
    void setLangTo(int position);
    void setTextIn(String text);
    void setTextOut(String text);

    @NonNull
    TranslateView getTranslateView();

}