package by.bntu.fitr.workload.service;

import by.bntu.fitr.workload.converter.GroupConverter;
import by.bntu.fitr.workload.model.GroupDto;
import by.bntu.fitr.workload.model.ObjectRef;
import by.bntu.fitr.workload.repository.dataaccess.GroupRepository;
import by.bntu.fitr.workload.repository.entity.Group;
import by.bntu.fitr.workload.repository.entity.Speciality;
import by.bntu.fitr.workload.repository.entity.Stream;
import by.bntu.fitr.workload.resolver.GroupResolver;
import by.bntu.fitr.workload.resolver.SpecialityResolver;
import by.bntu.fitr.workload.resolver.StreamResolver;
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

    @Autowired
    private StreamResolver streamResolver;

    @Override
    public GroupDto create(GroupDto groupDto) {
        Speciality speciality = specialityResolver.resolve(groupDto.getSpeciality());
        Stream stream = streamResolver.resolve(groupDto.getStream());
        Group entity = converter.convertToEntity(groupDto);
        entity.setId(null);
        entity.setSpeciality(speciality);
        entity.setStream(stream);
        entity = repository.save(entity);
        return converter.convertToDto(entity);
    }

    @Override
    public GroupDto update(Long id, GroupDto groupDto) {
        resolver.resolve(new ObjectRef(id));

        Group entity = converter.convertToEntity(groupDto);
        Speciality speciality = specialityResolver.resolve(groupDto.getSpeciality());
        Stream stream = streamResolver.resolve(groupDto.getStream());

        entity.setId(id);
        entity.setSpeciality(speciality);
        entity.setStream(stream);


        entity = repository.save(entity);
        return converter.convertToDto(entity);
    }
}
