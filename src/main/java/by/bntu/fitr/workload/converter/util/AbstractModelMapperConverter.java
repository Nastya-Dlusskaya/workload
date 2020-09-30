package by.bntu.fitr.workload.converter.util;

import by.bntu.fitr.workload.repository.entity.Base2;
import org.modelmapper.ModelMapper;

import java.lang.reflect.ParameterizedType;

//используется когда много полей ентити и дто совпадают
public abstract class AbstractModelMapperConverter<DTO, ENTITY extends Base2> extends AbstractCollectionConverter<DTO, ENTITY> {

    private final Class<ENTITY> entityClass;
    private final Class<DTO> dtoClass;
    protected ModelMapper modelMapper;

    public AbstractModelMapperConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
        this.entityClass = (Class<ENTITY>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        this.dtoClass = (Class<DTO>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    @Override
    public ENTITY convertToEntity(DTO dto) {
        return modelMapper.map(dto, this.entityClass);
    }

    @Override
    public DTO convertToDto(ENTITY entity) {
        return modelMapper.map(entity, this.dtoClass);
    }

}