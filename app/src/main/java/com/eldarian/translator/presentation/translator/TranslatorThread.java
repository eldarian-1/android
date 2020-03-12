package com.eldarian.translator.presentation.translator;

import com.eldarian.translator.api.YandexTranslateUseCase;
import com.eldarian.translator.app.TranslateView;

class TranslatorThread implements Runnable {

    private Thread thread;
    private TranslateView view;
    private TranslatorPresenter presenter;

    TranslatorThread(TranslateView view, TranslatorPresenter presenter){
        this.thread = new Thread(this, "translate");
        this.view = view;
        this.presenter = presenter;
        this.thread.start();
    }

    @Override
    public void run() {
        YandexTranslateUseCase yandexQuery = new YandexTranslateUseCase();
        yandexQuery.translate(presenter,view.getLangFrom() + "-" + view.getLangTo(), view.getTextIn());
    }

}