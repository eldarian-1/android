package com.eldarian.translator.domain;

import com.eldarian.translator.domain.print.ShowcasePrint;

import java.util.List;

import io.reactivex.Observable;

public interface ShowcaseUseCase {

    public Observable<List<ShowcasePrint>> allFilm();

}
