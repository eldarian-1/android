package com.eldarian.translator.presentation.translator;

import java.util.List;

public class TranslatorModel {

    private final TranslatorActivityPresenter presentor = new TranslatorActivityPresenter();

    List<String> getData(){
        List<String> data = List<String>();
        data.add("Hello world!");
        data.add("My name is Eldar");
        return data;
    }

}
