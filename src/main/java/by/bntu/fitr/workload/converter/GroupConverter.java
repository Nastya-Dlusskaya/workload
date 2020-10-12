package by.bntu.fitr.workload.converter;

import by.bntu.fitr.workload.converter.util.AbstractModelMapperConverter;
import by.bntu.fitr.workload.model.GroupDto;
import by.bntu.fitr.workload.repository.entity.Group;
import by.bntu.fitr.workload.repository.entity.Speciality;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class GroupConverter extends AbstractModelMapperConverter<GroupDto, Group> {

    public GroupConverter(ModelMapper modelMapper) {
        super(modelMapper);
    }

    @Override
    public Group convertToEntity(GroupDto groupDto) {
        Group entity = new Group();
        entity.setId(groupDto.getId());
        entity.setName(groupDto.getName());
        entity.setStudentCount(groupDto.getStudentCount());

        //ToDo
        Speciality speciality = new Speciality();
        speciality.setId(groupDto.getSpeciality().getId());
        speciality.setName(groupDto.getSpeciality().getName());
        entity.setSpeciality(speciality);
        return entity;
    }
}
