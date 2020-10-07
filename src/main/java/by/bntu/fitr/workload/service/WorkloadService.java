package by.bntu.fitr.workload.service;

import by.bntu.fitr.workload.converter.WorkloadConverter;
import by.bntu.fitr.workload.model.ObjectRef;
import by.bntu.fitr.workload.repository.dataaccess.WorkloadRepository;
import by.bntu.fitr.workload.repository.entity.Workload;
import by.bntu.fitr.workload.resolver.WorkloadResolver;
import by.bntu.fitr.workload.service.util.CrudServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class WorkloadService extends CrudServiceImpl<ObjectRef,
        Workload,
        WorkloadRepository,
        WorkloadConverter,
        WorkloadResolver> {

}