package by.bntu.fitr.workload.resolver.util;

import by.bntu.fitr.workload.exception.NotFoundException;
import by.bntu.fitr.workload.model.ObjectRef;
import by.bntu.fitr.workload.repository.dataaccess.FindByNameRepository;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractResolver<ENTITY, REPOSITORY extends FindByNameRepository<ENTITY, Long>> implements Resolver<ENTITY> {

    @Autowired
    private REPOSITORY repository;

    @Override
    public ENTITY resolve(ObjectRef objectRef) {
        if (objectRef.getId() == null && objectRef.getQualifier() == null) {
            throw new NotFoundException();
        }
        return objectRef.getId() != null ?
                repository.findById(objectRef.getId()).get() :
                repository.findByName(objectRef.getQualifier());
    }

}
