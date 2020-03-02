package com.eldarian.translator.translator;

public class TranslatorPresenter {

    private TranslatorView view;
    private TranslatorModel model;

    TranslatorPresenter(TranslatorModel model){
        this.model = model;
    }

    public void attachView(TranslatorView view) {
        view = view;
    }

    public void detachView() {
        view = null;
    }


    public void viewIsReady() {
        //loadUsers();
    }

}
