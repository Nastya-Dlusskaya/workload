package by.bntu.fitr.workload.converter;

import by.bntu.fitr.workload.converter.util.AbstractModelMapperConverter;
import by.bntu.fitr.workload.converter.util.CollectionConverter;
import by.bntu.fitr.workload.model.DepartmentDto;
import by.bntu.fitr.workload.model.ObjectRef;
import by.bntu.fitr.workload.repository.entity.Department;
import by.bntu.fitr.workload.repository.entity.Faculty;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class DepartmentConverter extends AbstractModelMapperConverter<DepartmentDto, Department> {

    public DepartmentConverter(ModelMapper modelMapper) {
        super(modelMapper);
    }

    @Override
    public Department convertToEntity(DepartmentDto departmentDto) {
        Department entity = new Department();
        entity.setId(departmentDto.getId());
        entity.setName(departmentDto.getName());
        //ToDo
        Faculty faculty = new Faculty();
        faculty.setId(departmentDto.getFaculty().getId());
        faculty.setName(departmentDto.getFaculty().getName());
        entity.setFaculty(faculty);
        return entity;
    }
}
