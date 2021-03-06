package by.bntu.fitr.workload.converter.util;

import by.bntu.fitr.workload.model.ObjectRef;
import by.bntu.fitr.workload.repository.entity.NamedEntity;

import java.lang.reflect.ParameterizedType;

public abstract class AbstractCollectionSimpleConverter<ENTITY extends NamedEntity> extends AbstractCollectionConverter<ObjectRef, ENTITY> {

    private final Class<ENTITY> entityClass;

    public AbstractCollectionSimpleConverter() {
        this.entityClass = (Class<ENTITY>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    @Override
    public ObjectRef convertToDto(ENTITY entity) {
        return new ObjectRef(entity.getId(), entity.getName());
    }

    @Override
    public ENTITY convertToEntity(ObjectRef objectRef) {
        try {
            ENTITY entity = this.entityClass.newInstance();
            entity.setId(objectRef.getId());
            entity.setName(objectRef.getName());
            return entity;
        } catch (Exception ex) {

        }
        return null;
    }
}
