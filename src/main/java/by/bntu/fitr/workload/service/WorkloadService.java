package by.bntu.fitr.workload.service;

import by.bntu.fitr.workload.converter.WorkloadConverter;
import by.bntu.fitr.workload.model.ObjectRef;
import by.bntu.fitr.workload.model.PlanDto;
import by.bntu.fitr.workload.model.WorkloadDto;
import by.bntu.fitr.workload.model.WorkloadType;
import by.bntu.fitr.workload.repository.dataaccess.WorkloadRepository;
import by.bntu.fitr.workload.repository.entity.Lecturer;
import by.bntu.fitr.workload.repository.entity.Plan;
import by.bntu.fitr.workload.repository.entity.Subject;
import by.bntu.fitr.workload.repository.entity.Workload;
import by.bntu.fitr.workload.resolver.LecturerResolver;
import by.bntu.fitr.workload.resolver.PlanResolver;
import by.bntu.fitr.workload.resolver.SubjectResolver;
import by.bntu.fitr.workload.resolver.WorkloadResolver;
import by.bntu.fitr.workload.service.util.CrudServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkloadService extends CrudServiceImpl<WorkloadDto,
        Workload,
        WorkloadRepository,
        WorkloadConverter,
        WorkloadResolver> {

    @Autowired
    private SubjectResolver subjectResolver;

    @Autowired
    private LecturerResolver lecturerResolver;

    @Autowired
    private PlanResolver planResolver;

    @Override
    public WorkloadDto create(WorkloadDto lecturerDto) {
        Plan plan = planResolver.resolve(lecturerDto.getPlan());
        Lecturer lecturer = lecturerResolver.resolve(lecturerDto.getLecturer());
        Subject subject = subjectResolver.resolve(lecturerDto.getSubject());

        Workload entity = converter.convertToEntity(lecturerDto);
        entity.setId(null);
        entity.setPlan(plan);
        entity.setLecturer(lecturer);
        entity.setSubject(subject);
        entity = repository.save(entity);

        return converter.convertToDto(entity);
    }

    @Override
    public WorkloadDto update(Long id, WorkloadDto workloadDto) {
        resolver.resolve(new ObjectRef(id));

        Workload entity = converter.convertToEntity(workloadDto);
        Plan plan = planResolver.resolve(workloadDto.getPlan());
        Lecturer lecturer = lecturerResolver.resolve(workloadDto.getLecturer());

        entity.setId(id);
        entity.setPlan(plan);
        entity.setLecturer(lecturer);

        entity = repository.save(entity);
        return converter.convertToDto(entity);
    }

    public List<WorkloadDto> getWorkloadsByPlanId(PlanDto plan) {
        return converter.convertToDtoList(repository.findByPlan(planResolver.resolve(plan)));
    }

    public List<WorkloadDto> getWorkloadsByPlanIdAndWorkloadType(PlanDto plan, WorkloadType type) {
        return converter.convertToDtoList(
                repository.findByPlanAndType(planResolver.resolve(plan), type.name()));
    }

}
