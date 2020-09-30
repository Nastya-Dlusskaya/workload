package by.bntu.fitr.workload.repository.dataaccess;

import by.bntu.fitr.workload.repository.entity.Group;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends FindByNameRepository<Group, Long> {
}
