package com.eldarian.translator.presentation.translator;

import java.util.ArrayList;
import java.util.List;

public class TranslatorModel {

    List<String> getData(){
        ArrayList<String> data = new ArrayList<String>();
        data.add("Hello world!");
        data.add("My name is Eldar");
        return data;
    }

}
