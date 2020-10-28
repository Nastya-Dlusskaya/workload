package by.bntu.fitr.workload.repository.dataaccess;

import by.bntu.fitr.workload.repository.entity.Stream;
import org.springframework.stereotype.Repository;

@Repository
public interface StreamRepository extends FindByNameRepository<Stream, Long> {
}
