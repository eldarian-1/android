package com.eldarian.translator.presentation.translator;

public interface TranslatorView {

    void setTextIn(String text);
    void setTextOut(String temp);
    void setLangIn(int position);
    void setLangOut(int position);

    String getTextIn();
    String getLangIn();
    String getLangOut();

}