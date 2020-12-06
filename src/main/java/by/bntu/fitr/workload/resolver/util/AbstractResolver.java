package by.bntu.fitr.workload.resolver.util;

import by.bntu.fitr.workload.exception.NotFoundException;
import by.bntu.fitr.workload.model.ObjectRef;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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

    @Override
    public List<ENTITY> resolve(List<ObjectRef> objectRefs) {
        return objectRefs.stream().map(this::resolve).collect(Collectors.toList());
    }

    public Set<ENTITY> resolve(Set<ObjectRef> objectRefs) {
        return objectRefs.stream().map(this::resolve).collect(Collectors.toSet());
    }

}
