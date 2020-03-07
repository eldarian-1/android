package com.eldarian.translator.app;

import com.eldarian.translator.database.Translates;

import java.io.Serializable;

public class Translations implements Serializable {

    private String textIn;
    private String textOut;
    private String langIn;
    private String langOut;

    public Translations(String langIn, String langOut, String textIn, String textOut) {
        this.langIn = langIn;
        this.langOut = langOut;
        this.textIn = textIn;
        this.textOut = textOut;
    }

    public String getTextIn() {
        return textIn;
    }

    public void setTextIn(String textIn) {
        this.textIn = textIn;
    }

    public String getTextOut() {
        return textOut;
    }

    public void setTextOut(String textOut) {
        this.textOut = textOut;
    }

    public String getLangIn() {
        return langIn;
    }

    public void setLangIn(String langIn) {
        this.langIn = langIn;
    }

    public String getLangOut() {
        return langOut;
    }

    public void setLangOut(String langOut) {
        this.langOut = langOut;
    }

    public Translates getTranslates(){
        Translates translate = new Translates();
        translate.langIn = this.langIn;
        translate.langOut = this.langOut;
        translate.textIn = this.textIn;
        translate.textOut = this.textOut;
        return translate;
    }

}
