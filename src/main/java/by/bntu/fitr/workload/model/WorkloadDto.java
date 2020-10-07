package by.bntu.fitr.workload.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class WorkloadDto {

    private WorkloadType type;

    private ObjectRef subject;
    private int amountHours;
    private LocalDate startDate;
    private LocalDate endDate;
    private WorkloadResultType resultType;
    private Boolean isApproved;

    private LecturerDto lecturer;

    private PlanDto plan;

    private Boolean isPlanned;
}
