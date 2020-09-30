package by.bntu.fitr.workload.repository.dataaccess;

import by.bntu.fitr.workload.repository.entity.AcademicDegree;
import org.springframework.stereotype.Repository;

@Repository
public interface AcademicDegreeRepository extends FindByNameRepository<AcademicDegree, Long> {
}
