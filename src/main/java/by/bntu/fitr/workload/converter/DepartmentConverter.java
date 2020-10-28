package by.bntu.fitr.workload.converter;

import by.bntu.fitr.workload.converter.util.AbstractModelMapperConverter;
import by.bntu.fitr.workload.model.DepartmentDto;
import by.bntu.fitr.workload.repository.entity.Department;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DepartmentConverter extends AbstractModelMapperConverter<DepartmentDto, Department> {

    @Autowired
    private FacultyConverter facultyConverter;

    public DepartmentConverter(ModelMapper modelMapper) {
        super(modelMapper);
    }

    @Override
    public Department convertToEntity(DepartmentDto departmentDto) {
        Department entity = new Department();
        entity.setId(departmentDto.getId());
        entity.setName(departmentDto.getName());

        entity.setFaculty(facultyConverter.convertToEntity(departmentDto.getFaculty()));
        return entity;
    }
}
