package by.bntu.fitr.workload.service;

import by.bntu.fitr.workload.converter.SpecialityConverter;
import by.bntu.fitr.workload.model.ObjectRef;
import by.bntu.fitr.workload.repository.dataaccess.SpecialityRepository;
import by.bntu.fitr.workload.repository.entity.Speciality;
import by.bntu.fitr.workload.resolver.SpecialityResolver;
import by.bntu.fitr.workload.service.util.CrudServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class SpecialityService extends CrudServiceImpl<ObjectRef,
        Speciality,
        SpecialityRepository,
        SpecialityConverter,
        SpecialityResolver> {

}
