package by.bntu.fitr.workload.resolver;

import by.bntu.fitr.workload.repository.dataaccess.DepartmentRepository;
import by.bntu.fitr.workload.repository.entity.Department;
import by.bntu.fitr.workload.resolver.util.AbstractResolver;
import org.springframework.stereotype.Component;

@Component
public class DepartmentResolver extends AbstractResolver<Department, DepartmentRepository> {

}
