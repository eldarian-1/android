package com.eldarian.translator.app.types;

public class Mapper {

    public static TranslateBase queryResponseToBase(TranslateQuery translateQuery, TranslateResponse translateResponse){
        TranslateBase translateBase = new TranslateBase();
        translateBase.lang = translateQuery.getLang();
        translateBase.textIn = translateQuery.getText();
        translateBase.textOut = translateResponse.text[0];
        return translateBase;
    }

    public static TranslateQuery viewToQuery(TranslateView translateView){
        TranslateQuery translateQuery = new TranslateQuery();
        translateQuery.setLang(translateView.getLangFrom() + "-" + translateView.getLangTo());
        translateQuery.setText(translateView.getTextIn());
        return translateQuery;
    }

}
