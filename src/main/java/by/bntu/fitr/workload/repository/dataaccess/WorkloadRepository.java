package by.bntu.fitr.workload.repository.dataaccess;

import by.bntu.fitr.workload.repository.entity.Plan;
import by.bntu.fitr.workload.repository.entity.Workload;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkloadRepository extends JpaRepository<Workload, Long> {

    List<Workload> findByPlan(Plan plan);

    List<Workload> findByPlanAndType(Plan plan, String type);

}
