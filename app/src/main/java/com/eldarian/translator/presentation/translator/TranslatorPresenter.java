package com.eldarian.translator.presentation.translator;

import com.eldarian.translator.app.App;
import com.eldarian.translator.domain.YandexQuery;
import com.eldarian.translator.app.Translations;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class TranslatorPresenter {

    private TranslatorView view;
    public TranslatorPresenter(){}

    public void pushQuery() throws IOException {
        YandexQuery query = new YandexQuery(view.getTextIn(),view.getLangIn(), view.getLangOut(), this);
        query.translate();
    }

    public void addTranslate(Translations translate){
        App instance = App.getInstance();
        instance.getDatabase().translateDao().insert(translate.getTranslates());
    }

    public void setTextOut(String text) throws JSONException {
        JSONObject json = new JSONObject(text);
        String textOut = json.getJSONArray("text").getString(0);
        addTranslate(new Translations(view.getLangIn(), view.getLangOut(), view.getTextIn(), textOut));
        view.setTextOut(textOut);
    }

    public void clearField() {
        view.setLangIn(0);
        view.setLangOut(0);
        view.setTextIn("");
        view.setTextOut("");
    }

    public void attachView(TranslatorView view) {
        this.view = view;
    }
    public void detachView() {
        view = null;
    }
    public void viewIsReady() {}

}