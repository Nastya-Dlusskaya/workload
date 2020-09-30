package by.bntu.fitr.workload.repository.dataaccess;

import by.bntu.fitr.workload.repository.entity.Department;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends FindByNameRepository<Department, Long> {
}
