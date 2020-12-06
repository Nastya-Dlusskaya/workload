package by.bntu.fitr.workload.repository.dataaccess;

import by.bntu.fitr.workload.repository.entity.Position;
import org.springframework.stereotype.Repository;

@Repository
public interface PositionRepository extends FindByNameRepository<Position, Long> {
}
