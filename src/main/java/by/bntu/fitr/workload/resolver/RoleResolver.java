package by.bntu.fitr.workload.resolver;

import by.bntu.fitr.workload.repository.dataaccess.RoleRepository;
import by.bntu.fitr.workload.repository.entity.Role;
import by.bntu.fitr.workload.resolver.util.AbstractResolver;
import org.springframework.stereotype.Component;

@Component
public class RoleResolver extends AbstractResolver<Role, RoleRepository> {
}
