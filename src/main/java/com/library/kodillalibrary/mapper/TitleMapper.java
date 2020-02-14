package com.library.kodillalibrary.mapper;

import com.library.kodillalibrary.domain.Title;
import com.library.kodillalibrary.domain.TitleDto;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class TitleMapper {

    public Title mapToBookTitle(final TitleDto titleDto) {
        return new Title(
                titleDto.getTitleId(),
                titleDto.getTitleName(),
                titleDto.getAuthor(),
                titleDto.getYearOfPublication(),
                titleDto.getTitleCopies()
                );
    }

    public TitleDto mapToBookTitleDto(final Title title) {
        return new TitleDto(
                title.getTitleId(),
                title.getTitleName(),
                title.getAuthor(),
                title.getYearOfPublication(),
                title.getTitleCopies()
        );
    }

    public List<TitleDto> mapToBookTitleDtoList(final List<Title> titleList) {
        return titleList.stream()
                .map(t -> new TitleDto(t.getTitleId(), t.getTitleName(), t.getAuthor(), t.getYearOfPublication(), t.getTitleCopies()))
                .collect(Collectors.toList());
    }

}
