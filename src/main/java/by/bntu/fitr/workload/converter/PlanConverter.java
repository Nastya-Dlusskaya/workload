package by.bntu.fitr.workload.converter;

import by.bntu.fitr.workload.converter.util.AbstractModelMapperConverter;
import by.bntu.fitr.workload.model.PlanDto;
import by.bntu.fitr.workload.repository.entity.Plan;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class PlanConverter extends AbstractModelMapperConverter<PlanDto, Plan> {


    public PlanConverter(ModelMapper modelMapper) {
        super(modelMapper);
    }
}
