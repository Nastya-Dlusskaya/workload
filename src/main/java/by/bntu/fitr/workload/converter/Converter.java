package by.bntu.fitr.workload.converter;

public interface Converter<DTO, ENTITY> {

    DTO convertToDto(ENTITY entity);
    ENTITY convertToEntity(DTO dto);

}
