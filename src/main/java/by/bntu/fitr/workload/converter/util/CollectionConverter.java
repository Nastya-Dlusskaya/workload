package by.bntu.fitr.workload.converter.util;

import org.springframework.data.domain.Page;

import java.util.Collection;
import java.util.List;
import java.util.Set;

public interface CollectionConverter<DTO, ENTITY> extends Converter<DTO, ENTITY> {

    List<DTO> convertToDtoList(Collection<ENTITY> entities);

    List<ENTITY> convertToEntityList(Collection<DTO> dtos);

    Set<DTO> convertToDtoSet(Collection<ENTITY> entities);

    Set<ENTITY> convertToEntitySet(Collection<DTO> dtos);

    Page<DTO> convertToDtoPage(Page<ENTITY> entities);

    Page<ENTITY> convertToEntityPage(Page<DTO> dtos);
}
