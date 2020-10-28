package by.bntu.fitr.workload.converter;

import by.bntu.fitr.workload.converter.util.AbstractModelMapperConverter;
import by.bntu.fitr.workload.model.GroupDto;
import by.bntu.fitr.workload.repository.entity.Group;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GroupConverter extends AbstractModelMapperConverter<GroupDto, Group> {

    @Autowired
    private SpecialityConverter specialityConverter;

    @Autowired
    private StreamConverter streamConverter;

    public GroupConverter(ModelMapper modelMapper) {
        super(modelMapper);
    }

    @Override
    public Group convertToEntity(GroupDto groupDto) {
        Group entity = new Group();
        entity.setId(groupDto.getId());
        entity.setName(groupDto.getName());
        entity.setStudentCount(groupDto.getStudentCount());

        entity.setSpeciality(specialityConverter.convertToEntity(groupDto.getSpeciality()));
        entity.setStream(streamConverter.convertToEntity(groupDto.getStream()));
        return entity;
    }
}
