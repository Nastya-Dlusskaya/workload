package by.bntu.fitr.workload.service;

import by.bntu.fitr.workload.converter.DepartmentConverter;
import by.bntu.fitr.workload.model.ObjectRef;
import by.bntu.fitr.workload.repository.dataaccess.DepartmentRepository;
import by.bntu.fitr.workload.repository.entity.Department;
import by.bntu.fitr.workload.resolver.DepartmentResolver;
import by.bntu.fitr.workload.service.util.CrudServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService extends CrudServiceImpl<ObjectRef,
        Department,
        DepartmentRepository,
        DepartmentConverter,
        DepartmentResolver> {

}
