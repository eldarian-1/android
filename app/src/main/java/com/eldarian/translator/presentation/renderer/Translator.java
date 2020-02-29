package com.eldarian.translator.presentation.renderer;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Translator implements Serializable {



    private String textIn;
    private String textOut;
    private String langIn;
    private String langOut;

    public Translator (String langIn, String langOut, String textIn, String textOut) {
        this.langIn = langIn;
        this.langOut = langOut;
        this.textIn = textIn;
        this.textOut = textOut;
    }

    static List<Translator> getList(){
        List<Translator> translations = new ArrayList<>();
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
