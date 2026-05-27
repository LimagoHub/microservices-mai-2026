package com.example.demo.presentation.mapper;

import com.example.demo.domain.model.Schwein;
import com.example.demo.presentation.dto.SchweinDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SchweinDtoMapper {

    SchweinDto convert(Schwein schwein);
    Schwein convert(SchweinDto schwein);
    Iterable<SchweinDto> convert(Iterable<Schwein> schweins);
}
