package com.library.kodillalibrary.mapper;

import com.library.kodillalibrary.domain.TitleCopy;
import com.library.kodillalibrary.domain.TitleCopyDto;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class TitleCopyMapper {
    public TitleCopy mapToBookCopy(final TitleCopyDto titleCopyDto) {
        return new TitleCopy(
                titleCopyDto.getCopieId(),
                titleCopyDto.getTitle(),
                titleCopyDto.getStatus(),
                titleCopyDto.getCopyLoans());
    }

    public TitleCopyDto mapToBookCopyDto(final TitleCopy titleCopy) {
        return new TitleCopyDto(
                titleCopy.getCopyId(),
                titleCopy.getTitle(),
                titleCopy.getStatus(),
                titleCopy.getCopyLoans());
    }

    public List<TitleCopyDto> mapToBookCopyDtoList(final List<TitleCopy> loanList) {
        return loanList.stream()
                .map(c -> new TitleCopyDto(c.getCopyId(), c.getTitle(), c.getStatus(), c.getCopyLoans()))
                .collect(Collectors.toList());
    }
}
