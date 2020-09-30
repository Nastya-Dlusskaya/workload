package by.bntu.fitr.workload.repository.repository;

import by.bntu.fitr.workload.repository.entity.Workload;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkloadRepository extends JpaRepository<Workload, Long> {
}
