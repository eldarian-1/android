package com.eldarian.translator.presentation.renderer;

import java.util.ArrayList;

public class Translator {

    static public final String API_KEY = "trnsl.1.1.20200223T101151Z.f0b089fcc9cceaea.b8f54373181a5280fe6485a26d2e68a2e6475c92";
    static public final String API_URI = "https://translate.yandex.net/api/v1.5/tr.json/getLangs";

    private String textIn;
    private String textOut;
    private String langIn;
    private String langOut;

    Translator () { }
    Translator (String langIn, String langOut, String textIn, String textOut) {
        this.langIn = langIn;
        this.langOut = langOut;
        this.textIn = textIn;
        this.textOut = textOut;
    }

    static ArrayList<Translator> getList(){
        ArrayList<Translator> translations = new ArrayList<Translator>();
        Translator temp = new Translator("En", "Ru", "Hello", "Privet");
        translations.add(temp);
        translations.add(temp);
        translations.add(temp);
        translations.add(temp);
        translations.add(temp);
        return translations;
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

}
