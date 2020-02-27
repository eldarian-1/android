package com.eldarian.translator.domain;

import com.eldarian.translator.Language;
import com.eldarian.translator.renderer.Translator;

public interface TranslateUseCase {
    public Translator translate(String world, Language lang);
}
