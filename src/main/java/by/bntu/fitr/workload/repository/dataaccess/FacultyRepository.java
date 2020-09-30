package by.bntu.fitr.workload.repository.dataaccess;

import by.bntu.fitr.workload.repository.entity.Faculty;
import org.springframework.stereotype.Repository;

@Repository
public interface FacultyRepository extends FindByNameRepository<Faculty, Long> {
}
