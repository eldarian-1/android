package com.eldarian.translator.presentation.translator;

import com.eldarian.translator.domain.YandexQuery;
import com.eldarian.translator.model.Translations;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class TranslatorPresenter {

    private TranslatorView view;
    private TranslatorModel model;

    TranslatorPresenter(TranslatorModel model){
        this.model = model;
    }

    public void pushQuery() throws IOException {
        YandexQuery query = new YandexQuery(view.getTextIn(),view.getLangIn(), view.getLangOut(), this);
        query.translate();
    }

    public void setTextOut(String text) throws JSONException {
        JSONObject json = new JSONObject(text);
        String textOut = json.getJSONArray("text").getString(0);
        model.addTranslate(new Translations(view.getLangIn(), view.getLangOut(), view.getTextIn(), textOut));
        view.setTextOut(textOut);
    }

    public void clearField() {
        view.setLangIn(0);
        view.setLangOut(0);
        view.setTextIn("");
        view.setTextOut("");
    }

    public void viewIsReady() {}
    public void attachView(TranslatorView view) {
        this.view = view;
    }
    public void detachView() {
        view = null;
    }

}