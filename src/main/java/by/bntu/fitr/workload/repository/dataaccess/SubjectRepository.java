package by.bntu.fitr.workload.repository.dataaccess;

import by.bntu.fitr.workload.repository.entity.Subject;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends FindByNameRepository<Subject, Long> {
}
