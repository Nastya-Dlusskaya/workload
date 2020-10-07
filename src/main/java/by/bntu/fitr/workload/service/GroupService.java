package by.bntu.fitr.workload.service;

import by.bntu.fitr.workload.converter.GroupConverter;
import by.bntu.fitr.workload.model.ObjectRef;
import by.bntu.fitr.workload.repository.dataaccess.GroupRepository;
import by.bntu.fitr.workload.repository.entity.Group;
import by.bntu.fitr.workload.resolver.GroupResolver;
import by.bntu.fitr.workload.service.util.CrudServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class GroupService extends CrudServiceImpl<ObjectRef,
        Group,
        GroupRepository,
        GroupConverter,
        GroupResolver> {

}
