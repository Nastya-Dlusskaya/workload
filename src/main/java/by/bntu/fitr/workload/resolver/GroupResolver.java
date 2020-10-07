package by.bntu.fitr.workload.resolver;

import by.bntu.fitr.workload.repository.dataaccess.GroupRepository;
import by.bntu.fitr.workload.repository.entity.Group;
import by.bntu.fitr.workload.resolver.util.AbstractResolver;
import org.springframework.stereotype.Component;

@Component
public class GroupResolver extends AbstractResolver<Group, GroupRepository> {

}
