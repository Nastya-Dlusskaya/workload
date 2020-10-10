package by.bntu.fitr.workload.service;

import by.bntu.fitr.workload.converter.AcademicRankConverter;
import by.bntu.fitr.workload.converter.SubjectConverter;
import by.bntu.fitr.workload.model.ObjectRef;
import by.bntu.fitr.workload.repository.dataaccess.AcademicRankRepository;
import by.bntu.fitr.workload.repository.entity.AcademicRank;
import by.bntu.fitr.workload.resolver.AcademicRankResolver;
import by.bntu.fitr.workload.resolver.SubjectResolver;
import by.bntu.fitr.workload.service.util.CrudServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class AcademicDegreeService extends CrudServiceImpl<ObjectRef,
        AcademicRank,
        AcademicRankRepository,
        AcademicRankConverter,
        AcademicRankResolver> {

}
