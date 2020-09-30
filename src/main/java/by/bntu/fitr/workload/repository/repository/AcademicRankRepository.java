package by.bntu.fitr.workload.repository.repository;

import by.bntu.fitr.workload.repository.entity.AcademicRank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AcademicRankRepository extends JpaRepository<AcademicRank, Long> {
}
