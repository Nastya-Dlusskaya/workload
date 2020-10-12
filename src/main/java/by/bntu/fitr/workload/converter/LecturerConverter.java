package by.bntu.fitr.workload.converter;

import by.bntu.fitr.workload.converter.util.AbstractModelMapperConverter;
import by.bntu.fitr.workload.model.LecturerDto;
import by.bntu.fitr.workload.repository.entity.AcademicDegree;
import by.bntu.fitr.workload.repository.entity.AcademicRank;
import by.bntu.fitr.workload.repository.entity.Lecturer;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class LecturerConverter extends AbstractModelMapperConverter<LecturerDto, Lecturer> {

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

        //ToDo
        AcademicRank rank = new AcademicRank();
        rank.setId(lecturerDto.getAcademicRank().getId());
        rank.setName(lecturerDto.getAcademicRank().getName());
        entity.setAcademicRank(rank);

        AcademicDegree degree = new AcademicDegree();
        degree.setId(lecturerDto.getAcademicDegree().getId());
        degree.setName(lecturerDto.getAcademicDegree().getName());
        entity.setAcademicDegree(degree);
        return entity;
    }
}
