package by.bntu.fitr.workload.service;

import by.bntu.fitr.workload.converter.SubjectConverter;
import by.bntu.fitr.workload.model.ObjectRef;
import by.bntu.fitr.workload.repository.dataaccess.SubjectRepository;
import by.bntu.fitr.workload.repository.entity.Subject;
import by.bntu.fitr.workload.resolver.SubjectResolver;
import by.bntu.fitr.workload.service.util.CrudServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class SubjectService extends CrudServiceImpl<ObjectRef,
        Subject,
        SubjectRepository,
        SubjectConverter,
        SubjectResolver> {

}
