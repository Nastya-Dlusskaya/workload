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

    @Autowired
    private PlanConverter planConverter;

    @Autowired
    private StreamConverter streamConverter;

    public WorkloadConverter(ModelMapper modelMapper) {
        super(modelMapper);
    }

    @Override
    public Workload convertToEntity(WorkloadDto workloadDto) {
        Workload entity = new Workload();
        entity.setId(workloadDto.getId());
        entity.setName(workloadDto.getName());
        entity.setType(workloadDto.getType().name());
        entity.setAmountHours(workloadDto.getAmountHours());
        entity.setStartDate(workloadDto.getStartDate());
        entity.setWorkDate(workloadDto.getWorkDate());
        entity.setEndDate(workloadDto.getEndDate());
        entity.setResultType(getResultType(workloadDto));
        entity.setIsApproved(workloadDto.getApproved());
        entity.setNotes(workloadDto.getNote());
        entity.setResultForm(workloadDto.getResultForm());

        entity.setSubject(subjectConverter.convertToEntity(workloadDto.getSubject()));
        entity.setLecturer(lecturerConverter.convertToEntity(workloadDto.getLecturer()));
        entity.setPlan(planConverter.convertToEntity(workloadDto.getPlan()));
        entity.setStream(streamConverter.convertToEntity(workloadDto.getStream()));

        return entity;
    }

    private String getResultType(WorkloadDto workloadDto) {
        return workloadDto.getResultType() == null ? null : workloadDto.getResultType().getValue();
    }
}
