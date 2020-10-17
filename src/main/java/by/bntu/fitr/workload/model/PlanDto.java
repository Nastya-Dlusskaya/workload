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
public class PlanDto extends ObjectRef {


    private LecturerDto lecturer;

    private DepartmentDto department;

    private LocalDate startDate;
    private LocalDate endDate;
    private LocalDate approvedDate;
}
