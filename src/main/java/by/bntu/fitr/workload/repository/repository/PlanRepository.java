package by.bntu.fitr.workload.repository.repository;

import by.bntu.fitr.workload.repository.entity.Plan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanRepository extends JpaRepository<Plan, Long> {
}
