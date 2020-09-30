package by.bntu.fitr.workload.converter;

import by.bntu.fitr.workload.model.entity.Subject;
import org.springframework.stereotype.Component;

@Component
public class SubjectConverter implements Converter<Subject, by.bntu.fitr.workload.repository.entity.Subject> {

    @Override
    public Subject convertToDto(by.bntu.fitr.workload.repository.entity.Subject subject) {
        return null;
    }

    @Override
    public by.bntu.fitr.workload.repository.entity.Subject convertToEntity(Subject subject) {
        return null;
    }
}
