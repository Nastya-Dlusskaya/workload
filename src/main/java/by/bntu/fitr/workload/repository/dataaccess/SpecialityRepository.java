package by.bntu.fitr.workload.repository.dataaccess;

import by.bntu.fitr.workload.repository.entity.Speciality;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecialityRepository extends FindByNameRepository<Speciality, Long> {
}
