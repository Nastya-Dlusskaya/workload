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
public class PlanDto extends ObjectRef {

    private String name;
    private LecturerDto lecturer;
    private LocalDate startDate;
    private LocalDate endDate;
    private LocalDate approvedDate;
    private String note;
}
