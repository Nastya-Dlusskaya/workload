package by.bntu.fitr.workload.converter;

import by.bntu.fitr.workload.converter.util.AbstractModelMapperConverter;
import by.bntu.fitr.workload.model.LecturerDto;
import by.bntu.fitr.workload.repository.entity.Lecturer;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LecturerConverter extends AbstractModelMapperConverter<LecturerDto, Lecturer> {

    @Autowired
    private AcademicRankConverter academicRankConverter;

    @Autowired
    private AcademicDegreeConverter academicDegreeConverter;

    @Autowired
    private PositionConverter positionConverter;

    public LecturerConverter(ModelMapper modelMapper) {
        super(modelMapper);
    }

    @Override
    public Lecturer convertToEntity(LecturerDto lecturerDto) {
        Lecturer entity = new Lecturer();
        entity.setId(lecturerDto.getId());
        entity.setName(lecturerDto.getName());
        entity.setSurname(lecturerDto.getSurname());
        entity.setPatronymic(lecturerDto.getPatronymic());
        entity.setEmail(lecturerDto.getEmail());
        entity.setMobilePhone(lecturerDto.getMobilePhone());
        entity.setHomePhone(lecturerDto.getHomePhone());
        entity.setWorkPhone(lecturerDto.getWorkPhone());
        entity.setSkype(lecturerDto.getSkype());
        entity.setHourPaid(lecturerDto.getHourPaid());
        entity.setStaff(lecturerDto.getStaff());
        entity.setBudget(lecturerDto.getBudget());

        entity.setAcademicRank(academicRankConverter.convertToEntity(lecturerDto.getAcademicRank()));
        entity.setAcademicDegree(academicDegreeConverter.convertToEntity(lecturerDto.getAcademicDegree()));
        entity.setPosition(positionConverter.convertToEntity(lecturerDto.getPosition()));
        return entity;
    }
}
