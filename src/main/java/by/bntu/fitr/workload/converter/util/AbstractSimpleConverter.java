package by.bntu.fitr.workload.converter.util;

import by.bntu.fitr.workload.model.ObjectRef;
import by.bntu.fitr.workload.repository.entity.Base2;

import java.lang.reflect.ParameterizedType;

//используется когда не нужны листы и дто - обжект реф
public abstract class AbstractSimpleConverter<ENTITY extends Base2> implements Converter<ObjectRef, ENTITY> {

    private final Class<ENTITY> entityClass;

    public AbstractSimpleConverter(Class<ENTITY> entityClass) {
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
