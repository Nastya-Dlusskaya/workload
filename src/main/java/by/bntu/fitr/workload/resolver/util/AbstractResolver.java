package by.bntu.fitr.workload.resolver.util;

import by.bntu.fitr.workload.exception.NotFoundException;
import by.bntu.fitr.workload.model.ObjectRef;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

public abstract class AbstractResolver<ENTITY, REPOSITORY extends JpaRepository<ENTITY, Long>> implements Resolver<ENTITY> {

    @Autowired
    private REPOSITORY repository;

    @Override
    public ENTITY resolve(ObjectRef objectRef) {
        if (objectRef.getId() == null && objectRef.getName() == null) {
            throw new NotFoundException();
        }
        return objectRef.getId() != null ?
                repository.findById(objectRef.getId()).get() :
                null;
    }

//    public ENTITY resolve(ObjectRef objectRef) {
//        if (objectRef.getId() == null && objectRef.getName() == null) {
//            throw new NotFoundException();
//        }
//        return objectRef.getId() != null ?
//                repository.findById(objectRef.getId()).get() :
//                repository.findByName(objectRef.getName());
//    }

}
