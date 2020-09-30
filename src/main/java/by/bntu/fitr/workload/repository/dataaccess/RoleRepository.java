package by.bntu.fitr.workload.repository.dataaccess;

import by.bntu.fitr.workload.repository.entity.Role;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends FindByNameRepository<Role, Long> {
}
