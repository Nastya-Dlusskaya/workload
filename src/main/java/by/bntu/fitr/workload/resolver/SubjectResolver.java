package by.bntu.fitr.workload.resolver;

import by.bntu.fitr.workload.repository.dataaccess.SubjectRepository;
import by.bntu.fitr.workload.repository.entity.Subject;
import by.bntu.fitr.workload.resolver.util.AbstractResolver;
import org.springframework.stereotype.Component;

@Component
public class SubjectResolver extends AbstractResolver<Subject, SubjectRepository> {

}
