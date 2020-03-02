package com.eldarian.translator.domain;

import com.eldarian.translator.Language;
import com.eldarian.translator.Translations;

public interface TranslateUseCase {
    public Translations translate(String world, Language lang);
}
