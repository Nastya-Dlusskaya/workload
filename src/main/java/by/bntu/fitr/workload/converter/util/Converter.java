package by.bntu.fitr.workload.converter.util;

public interface Converter<DTO, ENTITY> {

    DTO convertToDto(ENTITY entity);

    ENTITY convertToEntity(DTO dto);

}
