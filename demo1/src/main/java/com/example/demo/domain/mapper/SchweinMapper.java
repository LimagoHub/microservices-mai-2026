package com.example.demo.domain.mapper;

import com.example.demo.domain.model.Schwein;
import com.example.demo.persistence.SchweinEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SchweinMapper {
    Schwein convert(SchweinEntity schweinEntity);
    SchweinEntity convert(Schwein schwein);
    Iterable<Schwein> convert(Iterable<SchweinEntity> schweinEntity);
}
