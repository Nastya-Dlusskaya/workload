package by.bntu.fitr.workload.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class WorkloadDto extends ObjectRef {

    private WorkloadType type;

    private ObjectRef subject;
    private int amountHours;
    private LocalDate startDate;
    private LocalDate endDate;
    private LocalDate workDate;
    private EducationWorkloadType resultType;
    private Boolean approved;
    private String resultForm;
    private String note;

    private LecturerDto lecturer;
    private StreamDto stream;
    private PlanDto plan;

    private Boolean isPlanned;
}
