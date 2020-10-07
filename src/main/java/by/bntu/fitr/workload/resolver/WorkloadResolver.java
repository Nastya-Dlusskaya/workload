package by.bntu.fitr.workload.resolver;

import by.bntu.fitr.workload.repository.dataaccess.WorkloadRepository;
import by.bntu.fitr.workload.repository.entity.Workload;
import by.bntu.fitr.workload.resolver.util.AbstractResolver;
import org.springframework.stereotype.Component;

@Component
public class WorkloadResolver extends AbstractResolver<Workload, WorkloadRepository> {

}
