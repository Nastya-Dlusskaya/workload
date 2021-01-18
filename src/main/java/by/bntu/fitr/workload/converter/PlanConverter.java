package by.bntu.fitr.workload.converter;

import by.bntu.fitr.workload.converter.util.AbstractModelMapperConverter;
import by.bntu.fitr.workload.model.PlanDto;
import by.bntu.fitr.workload.repository.entity.Plan;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PlanConverter extends AbstractModelMapperConverter<PlanDto, Plan> {

    @Autowired
    private LecturerConverter lecturerConverter;

    public PlanConverter(ModelMapper modelMapper) {
        super(modelMapper);
    }

    @Override
    public Plan convertToEntity(PlanDto planDto) {
        Plan entity = new Plan();
        entity.setName(planDto.getName());
        entity.setStartDate(planDto.getStartDate());
        entity.setEndDate(planDto.getEndDate());
        entity.setApprovedDate(planDto.getApprovedDate());
        entity.setLecturer(lecturerConverter.convertToEntity(planDto.getLecturer()));
        entity.setNote(planDto.getNote());
        return entity;
    }
}
