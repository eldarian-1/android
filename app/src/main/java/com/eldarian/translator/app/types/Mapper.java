package com.eldarian.translator.app.types;

public class Mapper {

    public static TranslateBase queryResponseToBase(TranslateQuery translateQuery, String textOut){
        TranslateBase translateBase = new TranslateBase();
        translateBase.lang = translateQuery.getLang();
        translateBase.textIn = translateQuery.getText();
        translateBase.textOut = textOut;
        return translateBase;
    }

    public static TranslateQuery viewToQuery(TranslateView translateView){
        TranslateQuery translateQuery = new TranslateQuery();
        translateQuery.setLang(translateView.getLangFrom() + "-" + translateView.getLangTo());
        translateQuery.setText(translateView.getTextIn());
        return translateQuery;
    }

}
