package com.eldarian.translator.presentation.translator;

import com.eldarian.translator.app.TranslateView;

public interface TranslatorView {

    void init();

    void setLangFrom(int position);
    void setLangTo(int position);
    void setTextIn(String text);
    void setTextOut(String text);
    TranslateView getTranslateView();

}