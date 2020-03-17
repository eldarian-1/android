package com.eldarian.translator.app.types;

import androidx.annotation.NonNull;

public class Mapper {

    @NonNull
    public static TranslateBase viewResponseToBase(@NonNull TranslateView translateView, @NonNull String textOut){
        TranslateBase translateBase = new TranslateBase();
        translateBase.lang = translateView.getLangFrom() + "-" + translateView.getLangTo();
        translateBase.textIn = translateView.getTextIn();
        translateBase.textOut = textOut;
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
