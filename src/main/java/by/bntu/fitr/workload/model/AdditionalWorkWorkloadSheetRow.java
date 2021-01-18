package by.bntu.fitr.workload.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class AdditionalWorkWorkloadSheetRow {
    private String name;
    private int hours;
    private LocalDate startDate;
    private LocalDate endDate;
    private String note;
}
