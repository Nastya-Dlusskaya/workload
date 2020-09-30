package by.bntu.fitr.workload.service;

import by.bntu.fitr.workload.converter.SubjectConverter;
import by.bntu.fitr.workload.model.entity.Subject;
import by.bntu.fitr.workload.repository.repository.SubjectRepository;
import org.springframework.stereotype.Service;

@Service
public class SubjectService extends CrudServiceImpl<Subject, by.bntu.fitr.workload.repository.entity.Subject, SubjectRepository, SubjectConverter>{



}
