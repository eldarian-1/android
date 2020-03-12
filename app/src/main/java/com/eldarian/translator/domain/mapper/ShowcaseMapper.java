package com.eldarian.translator.domain.mapper;

import com.eldarian.translator.domain.print.ShowcasePrint;
import com.eldarian.translator.entity.dto.ShowcaseCore;

public class ShowcaseMapper {

    @Override
    protected ShowcasePrint mapImp(ShowcaseCore item){
        return new ShowcasePrint(
                item.getLink(),
                item.getTitle(),
                item.getPosterUrl()
        );
    }

}
