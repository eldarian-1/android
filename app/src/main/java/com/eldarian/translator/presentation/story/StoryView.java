package com.eldarian.translator.presentation.story;

import com.eldarian.translator.app.types.TranslateBase;

import java.util.List;

public interface StoryView {

    void init();
    void setTranslateList(List<TranslateBase> list);

}