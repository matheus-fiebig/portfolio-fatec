package br.gov.sp.cps.api.pixel.core.domain.mapper;

import br.gov.sp.cps.api.pixel.core.domain.dto.EspecieDTO;
import br.gov.sp.cps.api.pixel.core.domain.entity.Especie;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface EspecieMapper {
    EspecieDTO toDto(Especie especie);
}
