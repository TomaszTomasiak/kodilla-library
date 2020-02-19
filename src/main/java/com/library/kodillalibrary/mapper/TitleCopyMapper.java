package com.library.kodillalibrary.mapper;

import com.library.kodillalibrary.domain.TitleCopy;
import com.library.kodillalibrary.domain.TitleCopyDto;
import com.library.kodillalibrary.repository.TitleRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TitleCopyMapper {

    TitleRepository titleRepository;

    public TitleCopy mapToTitleCopy(final TitleCopyDto titleCopyDto) {
        return new TitleCopy(
                titleCopyDto.getCopyId(),
                titleRepository.findByTitleId(titleCopyDto.getTitleId()),
                titleCopyDto.getStatus(),
                titleCopyDto.getCopyLoans());
    }

    public TitleCopyDto mapToTitleCopyDto(final TitleCopy titleCopy) {
        return new TitleCopyDto(
                titleCopy.getCopyId(),
                titleCopy.getTitle().getTitleId(),
                titleCopy.getStatus(),
                titleCopy.getCopyLoans());
    }

    public List<TitleCopyDto> mapToTitleCopyDtoList(final List<TitleCopy> loanList) {
        return loanList.stream()
                .map(c -> new TitleCopyDto(c.getCopyId(), c.getTitle().getTitleId(), c.getStatus(), c.getCopyLoans()))
                .collect(Collectors.toList());
    }
}
