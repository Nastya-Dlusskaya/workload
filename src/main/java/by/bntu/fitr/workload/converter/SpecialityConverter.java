package by.bntu.fitr.workload.converter;

import by.bntu.fitr.workload.converter.util.AbstractCollectionSimpleConverter;
import by.bntu.fitr.workload.converter.util.CollectionConverter;
import by.bntu.fitr.workload.model.ObjectRef;
import by.bntu.fitr.workload.repository.entity.Speciality;
import org.springframework.stereotype.Component;

@Component
public class SpecialityConverter extends AbstractCollectionSimpleConverter<Speciality> implements CollectionConverter<ObjectRef, Speciality> {


}
