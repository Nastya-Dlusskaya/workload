package by.bntu.fitr.workload.service;

import by.bntu.fitr.workload.converter.DepartmentConverter;
import by.bntu.fitr.workload.model.DepartmentDto;
import by.bntu.fitr.workload.model.ObjectRef;
import by.bntu.fitr.workload.repository.dataaccess.DepartmentRepository;
import by.bntu.fitr.workload.repository.entity.Department;
import by.bntu.fitr.workload.repository.entity.Faculty;
import by.bntu.fitr.workload.resolver.DepartmentResolver;
import by.bntu.fitr.workload.resolver.FacultyResolver;
import by.bntu.fitr.workload.service.util.CrudServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService extends CrudServiceImpl<DepartmentDto,
        Department,
        DepartmentRepository,
        DepartmentConverter,
        DepartmentResolver> {

    @Autowired
    private FacultyResolver facultyResolver;

    @Override
    public DepartmentDto create(DepartmentDto departmentDto) {
        Faculty faculty = facultyResolver.resolve(departmentDto.getFaculty());
        Department entity = converter.convertToEntity(departmentDto);
        entity.setId(null);
        entity.setFaculty(faculty);
        entity = repository.save(entity);
        return converter.convertToDto(entity);
    }

    @Override
    public DepartmentDto update(Long id, DepartmentDto departmentDto) {
        resolver.resolve(new ObjectRef(id));

        Department entity = converter.convertToEntity(departmentDto);
        Faculty faculty = facultyResolver.resolve(departmentDto.getFaculty());

        entity.setId(id);
        entity.setFaculty(faculty);

        entity = repository.save(entity);
        return converter.convertToDto(entity);
    }
}
