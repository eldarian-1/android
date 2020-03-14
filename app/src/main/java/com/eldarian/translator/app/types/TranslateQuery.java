package com.eldarian.translator.app.types;

public class TranslateQuery {

    private String lang;
    private String text;

    public TranslateQuery(){}

    public TranslateQuery(String lang, String text){
        this.lang = lang;
        this.text = text;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
