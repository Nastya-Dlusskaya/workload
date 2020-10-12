package by.bntu.fitr.workload.service;

import by.bntu.fitr.workload.converter.GroupConverter;
import by.bntu.fitr.workload.model.GroupDto;
import by.bntu.fitr.workload.model.ObjectRef;
import by.bntu.fitr.workload.repository.dataaccess.GroupRepository;
import by.bntu.fitr.workload.repository.entity.Group;
import by.bntu.fitr.workload.repository.entity.Speciality;
import by.bntu.fitr.workload.resolver.GroupResolver;
import by.bntu.fitr.workload.resolver.SpecialityResolver;
import by.bntu.fitr.workload.service.util.CrudServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GroupService extends CrudServiceImpl<GroupDto,
        Group,
        GroupRepository,
        GroupConverter,
        GroupResolver> {

    @Autowired
    private SpecialityResolver specialityResolver;

    @Override
    public GroupDto create(GroupDto groupDto) {
        Speciality faculty = specialityResolver.resolve(groupDto.getSpeciality());
        Group entity = converter.convertToEntity(groupDto);
        entity.setId(null);
        entity.setSpeciality(faculty);
        entity = repository.save(entity);
        return converter.convertToDto(entity);
    }

    @Override
    public GroupDto update(Long id, GroupDto groupDto) {
        resolver.resolve(new ObjectRef(id));

        Group entity = converter.convertToEntity(groupDto);
        Speciality faculty = specialityResolver.resolve(groupDto.getSpeciality());

        entity.setId(id);
        entity.setSpeciality(faculty);

        entity = repository.save(entity);
        return converter.convertToDto(entity);
    }
}
