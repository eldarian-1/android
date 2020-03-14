package com.eldarian.translator.app.types;

import java.io.Serializable;

public class TranslateView implements Serializable {

    private String langFrom;
    private String langTo;
    private String textIn;
    private String textOut;

    public TranslateView() {}

    public TranslateView(String langFrom, String langTo, String textIn, String textOut) {
        this.langFrom = langFrom;
        this.langTo = langTo;
        this.textIn = textIn;
        this.textOut = textOut;
    }

    public String getLangFrom() {
        return langFrom;
    }

    public void setLangFrom(String langFrom) {
        this.langFrom = langFrom;
    }

    public String getLangTo() {
        return langTo;
    }

    public void setLangTo(String langTo) {
        this.langTo = langTo;
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

}
