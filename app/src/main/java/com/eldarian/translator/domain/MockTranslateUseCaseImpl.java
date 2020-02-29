package com.eldarian.translator.domain;

import com.eldarian.translator.Language;
import com.eldarian.translator.presentation.renderer.Translator;

public class MockTranslateUseCaseImpl implements TranslateUseCase{

    @Override
    public Translator translate(String world, Language lang) {
        return null;
    }

}
