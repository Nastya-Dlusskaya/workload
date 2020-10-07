package by.bntu.fitr.workload.resolver;

import by.bntu.fitr.workload.repository.dataaccess.FacultyRepository;
import by.bntu.fitr.workload.repository.entity.Faculty;
import by.bntu.fitr.workload.resolver.util.AbstractResolver;
import org.springframework.stereotype.Component;

@Component
public class FacultyResolver extends AbstractResolver<Faculty, FacultyRepository> {

}
