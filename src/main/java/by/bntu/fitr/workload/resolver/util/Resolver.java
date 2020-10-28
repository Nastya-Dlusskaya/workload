package by.bntu.fitr.workload.resolver.util;

import by.bntu.fitr.workload.model.ObjectRef;

import java.util.List;

public interface Resolver<ENTITY> {

    ENTITY resolve(ObjectRef objectRef);

    List<ENTITY> resolve(List<ObjectRef> objectRef);

}
