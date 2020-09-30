package by.bntu.fitr.workload.converter.util;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public abstract class AbstractCollectionConverter<DTO, ENTITY> implements CollectionConverter<DTO, ENTITY> {

    @Override
    abstract public DTO convertToDto(ENTITY entity);

    @Override
    abstract public ENTITY convertToEntity(DTO dto);

    @Override
    public List<DTO> convertToDtoList(Collection<ENTITY> entities) {
        return entities.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @Override
    public List<ENTITY> convertToEntityList(Collection<DTO> dtos) {
        return dtos.stream().map(this::convertToEntity).collect(Collectors.toList());
    }

    @Override
    public Set<DTO> convertToDtoSet(Collection<ENTITY> entities) {
        return entities.stream().map(this::convertToDto).collect(Collectors.toSet());
    }

    @Override
    public Set<ENTITY> convertToEntitySet(Collection<DTO> dtos) {
        return dtos.stream().map(this::convertToEntity).collect(Collectors.toSet());
    }
}
