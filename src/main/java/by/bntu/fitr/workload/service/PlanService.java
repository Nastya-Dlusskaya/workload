package by.bntu.fitr.workload.service;

import by.bntu.fitr.workload.converter.PlanConverter;
import by.bntu.fitr.workload.model.*;
import by.bntu.fitr.workload.repository.dataaccess.PlanRepository;
import by.bntu.fitr.workload.repository.entity.Plan;
import by.bntu.fitr.workload.resolver.PlanResolver;
import by.bntu.fitr.workload.service.util.CrudServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class PlanService
        extends CrudServiceImpl<PlanDto, Plan, PlanRepository, PlanConverter, PlanResolver> {

  @Autowired
  private WorkloadService workloadService;

  public List<EducationWorkloadSheetRow> getEducationPlan(Long planId) {
    PlanDto planDto = find(planId);
    if (planDto == null) {
      return Collections.EMPTY_LIST;
    }
    List<WorkloadDto> workloadsByPlanId =
            workloadService.getWorkloadsByPlanIdAndWorkloadType(planDto, WorkloadType.EDUCATION);

    Map<ObjectRef, List<WorkloadDto>> workloadsBySubject =
            workloadsByPlanId.stream()
                    .collect(Collectors.groupingBy(WorkloadDto::getSubject, Collectors.toList()));

    List<EducationWorkloadSheetRow> rows = new LinkedList<>();
    workloadsBySubject.forEach(
            (key, value) -> {
              rows.add(
                      EducationWorkloadSheetRow.builder()
                              .subjectName(key.getName())
                              .items(getWorkloadItems(value))
                              .build());
            });

    return rows;
  }

  private List<EducationWorkloadSheetItem> getWorkloadItems(List<WorkloadDto> workloads) {
    List<EducationWorkloadSheetItem> items = new LinkedList<>();
    Map<EducationWorkloadType, List<WorkloadDto>> workloadByType =
            workloads.stream()
                    .collect(Collectors.groupingBy(WorkloadDto::getResultType, Collectors.toList()));
    workloadByType.forEach(
            (key, value) -> {
              items.add(
                      EducationWorkloadSheetItem.builder()
                              .name(key.name())
                              .expected(getWorkloadCountValue(value, true))
                              .actual(getWorkloadCountValue(value, false))
                              .build());
            });
    return items;
  }

  private int getWorkloadCountValue(List<WorkloadDto> workloads, boolean value) {
    return workloads.stream()
            .collect(Collectors.groupingBy(WorkloadDto::getIsPlanned, Collectors.toList()))
            .get(value)
            .stream()
            .mapToInt(WorkloadDto::getAmountHours)
            .sum();
  }
}
