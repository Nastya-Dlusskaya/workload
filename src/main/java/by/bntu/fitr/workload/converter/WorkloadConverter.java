package by.bntu.fitr.workload.converter;

import by.bntu.fitr.workload.converter.util.AbstractModelMapperConverter;
import by.bntu.fitr.workload.model.WorkloadDto;
import by.bntu.fitr.workload.repository.entity.Workload;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WorkloadConverter extends AbstractModelMapperConverter<WorkloadDto, Workload> {

    @Autowired
    private LecturerConverter lecturerConverter;

    @Autowired
    private SubjectConverter subjectConverter;

    public WorkloadConverter(ModelMapper modelMapper) {
        super(modelMapper);
    }

    @Override
    public Workload convertToEntity(WorkloadDto workloadDto) {
        Workload entity = new Workload();
        entity.setId(workloadDto.getId());
        entity.setType(workloadDto.getType().name());
        entity.setAmountHours(workloadDto.getAmountHours());
        entity.setStartDate(workloadDto.getStartDate());
        entity.setEndDate(workloadDto.getEndDate());
        entity.setResultType(workloadDto.getResultType().name());
        entity.setIsApproved(workloadDto.getApproved());

        entity.setSubject(subjectConverter.convertToEntity(workloadDto.getSubject()));
        entity.setLecturer(lecturerConverter.convertToEntity(workloadDto.getLecturer()));

        return entity;
    }
}
