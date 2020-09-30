package by.bntu.fitr.workload.repository.dataaccess;

import by.bntu.fitr.workload.repository.entity.AcademicRank;
import org.springframework.stereotype.Repository;

@Repository
public interface AcademicRankRepository extends FindByNameRepository<AcademicRank, Long> {
}
