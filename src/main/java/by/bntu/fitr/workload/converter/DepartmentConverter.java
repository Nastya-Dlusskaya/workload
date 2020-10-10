package by.bntu.fitr.workload.converter;

import by.bntu.fitr.workload.converter.util.AbstractModelMapperConverter;
import by.bntu.fitr.workload.model.DepartmentDto;
import by.bntu.fitr.workload.repository.entity.Department;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class DepartmentConverter extends AbstractModelMapperConverter<DepartmentDto, Department> {

    public DepartmentConverter(ModelMapper modelMapper) {
        super(modelMapper);
    }
}
