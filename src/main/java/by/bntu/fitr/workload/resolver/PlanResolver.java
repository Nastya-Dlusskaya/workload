package by.bntu.fitr.workload.resolver;

import by.bntu.fitr.workload.repository.dataaccess.PlanRepository;
import by.bntu.fitr.workload.repository.entity.Plan;
import by.bntu.fitr.workload.resolver.util.AbstractResolver;
import org.springframework.stereotype.Component;

@Component
public class PlanResolver extends AbstractResolver<Plan, PlanRepository> {

}
