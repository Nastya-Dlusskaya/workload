package by.bntu.fitr.workload.repository.repository;

import by.bntu.fitr.workload.repository.entity.AcademicDegree;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AcademicDegreeRepository  extends JpaRepository<AcademicDegree, Long> {
}
