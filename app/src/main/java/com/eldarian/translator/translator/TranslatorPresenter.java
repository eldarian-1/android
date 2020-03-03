package com.eldarian.translator.translator;

import com.eldarian.translator.QueryYandex;

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
        view.setTextOut(json.getJSONArray("text").getString(0));
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