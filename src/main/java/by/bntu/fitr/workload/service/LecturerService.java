package by.bntu.fitr.workload.service;

import by.bntu.fitr.workload.converter.LecturerConverter;
import by.bntu.fitr.workload.model.LecturerDto;
import by.bntu.fitr.workload.model.ObjectRef;
import by.bntu.fitr.workload.repository.dataaccess.LecturerRepository;
import by.bntu.fitr.workload.repository.entity.AcademicDegree;
import by.bntu.fitr.workload.repository.entity.AcademicRank;
import by.bntu.fitr.workload.repository.entity.Lecturer;
import by.bntu.fitr.workload.resolver.AcademicDegreeResolver;
import by.bntu.fitr.workload.resolver.AcademicRankResolver;
import by.bntu.fitr.workload.resolver.LecturerResolver;
import by.bntu.fitr.workload.service.util.CrudServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LecturerService extends CrudServiceImpl<LecturerDto,
        Lecturer,
        LecturerRepository,
        LecturerConverter,
        LecturerResolver> {

    @Autowired
    private AcademicRankResolver academicRankResolver;

    @Autowired
    private AcademicDegreeResolver academicDegreeResolver;

    @Override
    public LecturerDto create(LecturerDto lecturerDto) {
        AcademicDegree degree = academicDegreeResolver.resolve(lecturerDto.getAcademicDegree());
        AcademicRank rank = academicRankResolver.resolve(lecturerDto.getAcademicRank());

        Lecturer entity = converter.convertToEntity(lecturerDto);
        entity.setId(null);
        entity.setAcademicDegree(degree);
        entity.setAcademicRank(rank);
        entity = repository.save(entity);

        return converter.convertToDto(entity);
    }

    @Override
    public LecturerDto update(Long id, LecturerDto lecturerDto) {
        resolver.resolve(new ObjectRef(id));

        Lecturer entity = converter.convertToEntity(lecturerDto);
        AcademicRank rank = academicRankResolver.resolve(lecturerDto.getAcademicRank());
        AcademicDegree degree = academicDegreeResolver.resolve(lecturerDto.getAcademicDegree());

        entity.setId(id);
        entity.setAcademicRank(rank);
        entity.setAcademicDegree(degree);

        entity = repository.save(entity);
        return converter.convertToDto(entity);
    }

}
