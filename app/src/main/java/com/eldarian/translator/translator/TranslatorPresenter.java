package com.eldarian.translator.translator;

import com.eldarian.translator.QueryYandex;
import com.eldarian.translator.Translations;

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
        QueryYandex query = new QueryYandex(view.getTextIn(),view.getLangIn(), view.getLangOut(), this);
        query.getTextOut();
    }

    public void setTextOut(String text) throws JSONException {
        JSONObject json = new JSONObject(text);
        String textOut = json.getJSONArray("text").getString(0);
        model.addTranslate(new Translations(view.getLangIn(), view.getLangOut(), view.getTextIn(), textOut));
        view.setTextOut(textOut);
    }

    public void viewIsReady() {
        //loadUsers();
    }
    public void attachView(TranslatorView view) {
        this.view = view;
    }
    public void detachView() {
        view = null;
    }

}