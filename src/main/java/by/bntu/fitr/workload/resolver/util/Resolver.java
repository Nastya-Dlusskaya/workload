package by.bntu.fitr.workload.resolver.util;

import by.bntu.fitr.workload.model.ObjectRef;

public interface Resolver<ENTITY> {

    ENTITY resolve(ObjectRef objectRef);

}
