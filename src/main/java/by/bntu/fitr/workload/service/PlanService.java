package by.bntu.fitr.workload.service;

import by.bntu.fitr.workload.converter.PlanConverter;
import by.bntu.fitr.workload.model.PlanDto;
import by.bntu.fitr.workload.repository.dataaccess.PlanRepository;
import by.bntu.fitr.workload.repository.entity.Plan;
import by.bntu.fitr.workload.resolver.PlanResolver;
import by.bntu.fitr.workload.service.util.CrudServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class PlanService extends CrudServiceImpl<PlanDto,
        Plan,
        PlanRepository,
        PlanConverter,
        PlanResolver> {

}
