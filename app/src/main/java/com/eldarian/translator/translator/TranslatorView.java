package com.eldarian.translator.translator;

public interface TranslatorView {

    void setTextIn(String text);
    void setTextOut(String temp);
    String getTextIn();
    String getLangIn();
    String getLangOut();
    void clearField();

}