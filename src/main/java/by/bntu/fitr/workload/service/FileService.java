package by.bntu.fitr.workload.service;

import by.bntu.fitr.workload.model.*;
import by.bntu.fitr.workload.util.filewriter.ExcelWorkloadFileWriter;
import by.bntu.fitr.workload.util.filewriter.WorkloadFileWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import static by.bntu.fitr.workload.model.WorkloadType.*;

@Service
public class FileService {

  @Autowired
  private WorkloadService workloadService;

  @Autowired
  private PlanService planService;

  public File getFile(Long id) throws IOException {
    WorkloadFileWriter workloadFileWriter = new ExcelWorkloadFileWriter();
    return workloadFileWriter.writeFile(getWorkloadBook(id));
  }

  private Book getWorkloadBook(Long id) {
    PlanDto planDto = planService.find(id);

    return Book.builder()
            .name(getBookName(planDto))
            .workloadSheets(getWorkloadSheets(planDto))
            .build();
  }

  private String getBookName(PlanDto planDto) {
    return planDto.getLecturer().getFullName().replace(" ", "_").replace("\\", "-")
            + "_"
            + planDto.getName().replace("/", "-")
            + "_"
            + "("
            + LocalDate.now()
            + ")";
  }

  private List<WorkloadSheet> getWorkloadSheets(PlanDto planDto) {
    List<WorkloadDto> workloads = workloadService.getWorkloadsByPlanId(planDto);
    Map<WorkloadType, List<WorkloadDto>> groupWorkloads =
            workloads.stream()
                    .collect(Collectors.groupingBy(WorkloadDto::getType, Collectors.toList()));
    List<WorkloadSheet> workloadSheets = new LinkedList<>();

    for (Map.Entry<WorkloadType, List<WorkloadDto>> pair : groupWorkloads.entrySet()) {
      List<WorkloadDto> workloadTypeItems = pair.getValue();
      if (workloadTypeItems.isEmpty()) {
        continue;
      }
      workloadSheets.add(getWorkloadSheetByType(pair.getKey(), workloadTypeItems, planDto.getId()));
    }
    workloadSheets.addAll(getMonthlyWorkloads(planDto, workloads));

    return workloadSheets;
  }

  private WorkloadSheet getWorkloadSheetByType(
          WorkloadType type, List<WorkloadDto> workloadTypeItems, Long id) {
    WorkloadSheet sheet = null;
    switch (type) {
      case EDUCATION:
        sheet = getEducationSheet(id);
        break;
      case EDUCATION_METHODICAL:
        sheet = getEducationMethodicalSheet(workloadTypeItems, WorkloadType.EDUCATION_METHODICAL);
        break;
      case SCIENTIFIC_RESEARCH:
        sheet = getScientificResearchSheet(workloadTypeItems, WorkloadType.SCIENTIFIC_RESEARCH);
        break;
      case SOCIAL:
        sheet = getEducationMethodicalSheet(workloadTypeItems, SOCIAL);
        break;
      case ORGANIZATIONAL_METHODICAL:
        sheet = getEducationMethodicalSheet(workloadTypeItems, ORGANIZATIONAL_METHODICAL);
        break;
      case NONE:
        sheet = null;
        break;
      default:
        throw new IllegalStateException("Unexpected value: " + type);
    }
    return sheet;
  }

  private List<WorkloadDto> getFilteredWorkloads(
          List<WorkloadDto> workloadTypeItems, WorkloadType type) {
    return workloadTypeItems.stream()
            .filter(workload -> workload.getType() == type)
            .collect(Collectors.toList());
  }

  private WorkloadSheet getEducationSheet(Long id) {
    EducationWorkloadSheet workloadSheet = new EducationWorkloadSheet();
    workloadSheet.setName(WorkloadType.EDUCATION.getAppValue());
    workloadSheet.setSheetRows(planService.getEducationPlan(id));
    return workloadSheet;
  }

  private WorkloadSheet getEducationMethodicalSheet(
          List<WorkloadDto> workloadTypeItems, WorkloadType workloadType) {
    AdditionalWorkWorkloadSheet workloadSheet = new AdditionalWorkWorkloadSheet();
    workloadSheet.setName(workloadType.getAppValue());
    workloadTypeItems.stream()
            .map(
                    workloadDto ->
                            AdditionalWorkWorkloadSheetRow.builder()
                                    .name(workloadDto.getName())
                                    .hours(workloadDto.getAmountHours())
                                    .startDate(workloadDto.getStartDate())
                                    .endDate(workloadDto.getEndDate())
                                    .note(workloadDto.getNote())
                                    .build())
            .forEach(workloadSheet::addRow);
    return workloadSheet;
  }

  private WorkloadSheet getScientificResearchSheet(
          List<WorkloadDto> workloadTypeItems, WorkloadType workloadType) {
    ScienceWorkloadSheet workloadSheet = new ScienceWorkloadSheet();
    workloadSheet.setName(workloadType.getAppValue());
    for (WorkloadDto workloadDto : workloadTypeItems) {
      ScienceWorkloadSheetRow educationWorkloadSheetRow = new ScienceWorkloadSheetRow();
      educationWorkloadSheetRow.setName(workloadDto.getName());
      educationWorkloadSheetRow.setHours(workloadDto.getAmountHours());
      educationWorkloadSheetRow.setStartDate(workloadDto.getStartDate());
      educationWorkloadSheetRow.setEndDate(workloadDto.getEndDate());
      educationWorkloadSheetRow.setNote(workloadDto.getNote());
      educationWorkloadSheetRow.setResultForm(workloadDto.getResultForm());
      workloadSheet.addRow(educationWorkloadSheetRow);
    }
    return workloadSheet;
  }

  private List<? extends WorkloadSheet> getMonthlyWorkloads(
          PlanDto planDto, List<WorkloadDto> groupWorkloads) {
    List<MonthlyWorkloadSheet> sheets = new LinkedList<>();
    LocalDate startDate = planDto.getStartDate();
    LocalDate indexDate = LocalDate.of(startDate.getYear(), startDate.getMonth(), 1);
    while (indexDate.isBefore(planDto.getEndDate())) {
      List<WorkloadDto> educationWorkloads =
              getEducationWorkloadByTypeAndDate(groupWorkloads, indexDate);
      List<WorkloadDto> additionalWorkloads =
              getAdditionalWorkloadByTypeAndDate(groupWorkloads, indexDate);

      MonthlyWorkloadSheet builder = new MonthlyWorkloadSheet();
      builder.setEducationMethodical(getWorkloadHour(additionalWorkloads, EDUCATION_METHODICAL));
      builder.setOrganizationalMethodical(
              getWorkloadHour(additionalWorkloads, ORGANIZATIONAL_METHODICAL));
      builder.setScientificResearch(getWorkloadHour(additionalWorkloads, SCIENTIFIC_RESEARCH));
      builder.setSheetRows(getEducationWorkloadByDays(educationWorkloads));
      builder.setName(
              indexDate.getMonth().getDisplayName(TextStyle.FULL, Locale.getDefault())
                      + " "
                      + indexDate.getYear());

      sheets.add(builder);
      indexDate = indexDate.plusMonths(1);
    }
    return sheets;
  }

  private List<WorkloadDto> getAdditionalWorkloadByTypeAndDate(
          List<WorkloadDto> groupWorkloads, LocalDate indexDate) {
    return groupWorkloads.stream()
            .filter(workload -> workload.getType() != EDUCATION)
            .filter(
                    workload ->
                            workload.getStartDate().isAfter(indexDate)
                                    || workload.getEndDate().isBefore(indexDate.plusMonths(1)))
            .sorted(Comparator.comparing(WorkloadDto::getStartDate))
            .collect(Collectors.toList());
  }

  private String getMonthlySheetName(LocalDate indexDate) {
    return indexDate.getMonth() + " " + indexDate.getYear();
  }

  private List<WorkloadDto> getEducationWorkloadByTypeAndDate(
          List<WorkloadDto> groupWorkloads, LocalDate finalStartDate) {
    return groupWorkloads.stream()
            .filter(workload -> workload.getType() == EDUCATION)
            .filter(WorkloadDto::getIsPlanned)
            .filter(
                    workload ->
                            workload.getWorkDate().isAfter(finalStartDate)
                                    && workload.getWorkDate().isBefore(finalStartDate.plusMonths(1)))
            .sorted(Comparator.comparing(WorkloadDto::getWorkDate))
            .collect(Collectors.toList());
  }

  private int getWorkloadHour(List<WorkloadDto> groupWorkloads, WorkloadType type) {
    return groupWorkloads.stream()
            .filter(workload -> workload.getType() == type)
            .mapToInt(WorkloadDto::getAmountHours)
            .sum();
  }

  private List<MonthlyWorkloadSheetRow> getEducationWorkloadByDays(
          List<WorkloadDto> datesWorkloads) {
    List<MonthlyWorkloadSheetRow> list = new LinkedList<>();
    Map<LocalDate, List<WorkloadDto>> localDateListMap =
            datesWorkloads.stream()
                    .filter(workload -> workload.getType() == EDUCATION)
                    .filter(WorkloadDto::getIsPlanned)
                    .sorted(Comparator.comparing(WorkloadDto::getWorkDate))
                    .collect(Collectors.groupingBy(WorkloadDto::getWorkDate, Collectors.toList()));

    for (Entry<LocalDate, List<WorkloadDto>> entry : localDateListMap.entrySet()) {
      LocalDate date = entry.getKey();
      Map<String, List<WorkloadDto>> datedWorkload =
              entry.getValue().stream()
                      .collect(
                              Collectors.groupingBy(
                                      workloadDto -> workloadDto.getSubject().getName(), Collectors.toList()));
      datedWorkload.forEach(
              (subject, workloads) -> {
                list.add(
                        MonthlyWorkloadSheetRow.builder()
                                .date(date)
                                .subjectName(subject)
                                .lecturerHours(getWorkloadTypeSum(workloads, EducationWorkloadType.LECTURE))
                                .laboratoryHours(
                                        getWorkloadTypeSum(workloads, EducationWorkloadType.LABORATORY))
                                .practiseHours(getWorkloadTypeSum(workloads, EducationWorkloadType.PRACTISE))
                                .setOffHours(getWorkloadTypeSum(workloads, EducationWorkloadType.SET_OFF))
                                .diplomaHours(getWorkloadTypeSum(workloads, EducationWorkloadType.DIPLOMA))
                                .examHours(
                                        getWorkloadTypeSum(workloads, EducationWorkloadType.EXAM)
                                                + getWorkloadTypeSum(workloads, EducationWorkloadType.EXAM_COMMITTEE))
                                .courseworkHours(
                                        getWorkloadTypeSum(workloads, EducationWorkloadType.COURSEWORK))
                                .consultationHours(
                                        getWorkloadTypeSum(workloads, EducationWorkloadType.CONSULTATION))
                                .fieldTripHours(getWorkloadTypeSum(workloads, EducationWorkloadType.FIELD_TRIP))
                                .build());
              });
    }
    return list;
  }

  private int getWorkloadTypeSum(List<WorkloadDto> workloads, EducationWorkloadType type) {
    return workloads.stream()
            .filter(workload -> workload.getResultType() == type)
            .mapToInt(WorkloadDto::getAmountHours)
            .sum();
  }
}
