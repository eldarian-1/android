package com.eldarian.translator.domain;

import android.database.Observable;

import com.eldarian.translator.domain.mapper.ShowcaseMapper;
import com.eldarian.translator.domain.print.ShowcasePrint;
import com.eldarian.translator.entity.dto.ShowcaseCore;
import com.eldarian.translator.entity.repository.ShowcaseRepository;

import java.util.ArrayList;
import java.util.List;

public class ShowcaseUseCaseImpl implements ShowcaseUseCase {

    private final ShowcaseRepository repository;
    private final ShowcaseMapper showcaseMapper;

    public ShowcaseUseCaseImpl(ShowcaseRepository repository){
        this.repository = repository;
        showcaseMapper = new ShowcaseMapper();
    }

    @Override
    public Observable<List<ShowcasePrint>> map(List<ShowcaseCore> items){

        List<ShowcasePrint> newItems = new ArrayList<>();
        for(ShowcaseCore showcaseCore : items){
            newItems.add(showcaseMapper.map(showcaseCore));
        }
        return newItems;
    }

    @Override
    public Observable<List<ShowcasePrint>> allFilm() {
        return repository.all().map(this::map);
    }
}
