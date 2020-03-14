package com.eldarian.translator.app.types;

import androidx.annotation.NonNull;

public class Mapper {

    @NonNull
    public static TranslateBase queryResponseToBase(@NonNull TranslateQuery translateQuery, @NonNull TranslateResponse translateResponse){
        TranslateBase translateBase = new TranslateBase();
        translateBase.lang = translateQuery.getLang();
        translateBase.textIn = translateQuery.getText();
        translateBase.textOut = translateResponse.text[0];
        return translateBase;
    }

    @NonNull
    public static TranslateQuery viewToQuery(@NonNull TranslateView translateView){
        TranslateQuery translateQuery = new TranslateQuery();
        translateQuery.setLang(translateView.getLangFrom() + "-" + translateView.getLangTo());
        translateQuery.setText(translateView.getTextIn());
        return translateQuery;
    }

}
