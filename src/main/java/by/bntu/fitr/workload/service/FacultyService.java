package by.bntu.fitr.workload.service;

import by.bntu.fitr.workload.converter.FacultyConverter;
import by.bntu.fitr.workload.model.ObjectRef;
import by.bntu.fitr.workload.repository.dataaccess.FacultyRepository;
import by.bntu.fitr.workload.repository.entity.Faculty;
import by.bntu.fitr.workload.resolver.FacultyResolver;
import by.bntu.fitr.workload.service.util.CrudServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class FacultyService extends CrudServiceImpl<ObjectRef,
        Faculty,
        FacultyRepository,
        FacultyConverter,
        FacultyResolver> {

}
