package by.bntu.fitr.workload.service;

import by.bntu.fitr.workload.converter.LecturerConverter;
import by.bntu.fitr.workload.model.ObjectRef;
import by.bntu.fitr.workload.repository.dataaccess.LecturerRepository;
import by.bntu.fitr.workload.repository.entity.Lecturer;
import by.bntu.fitr.workload.resolver.LecturerResolver;
import by.bntu.fitr.workload.service.util.CrudServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class LecturerService extends CrudServiceImpl<ObjectRef,
        Lecturer,
        LecturerRepository,
        LecturerConverter,
        LecturerResolver> {

}
