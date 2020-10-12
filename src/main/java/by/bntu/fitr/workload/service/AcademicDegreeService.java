package by.bntu.fitr.workload.service;

import by.bntu.fitr.workload.converter.AcademicDegreeConverter;
import by.bntu.fitr.workload.model.ObjectRef;
import by.bntu.fitr.workload.repository.dataaccess.AcademicDegreeRepository;
import by.bntu.fitr.workload.repository.entity.AcademicDegree;
import by.bntu.fitr.workload.resolver.AcademicDegreeResolver;
import by.bntu.fitr.workload.service.util.CrudServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class AcademicDegreeService extends CrudServiceImpl<ObjectRef,
        AcademicDegree,
        AcademicDegreeRepository,
        AcademicDegreeConverter,
        AcademicDegreeResolver> {

}
