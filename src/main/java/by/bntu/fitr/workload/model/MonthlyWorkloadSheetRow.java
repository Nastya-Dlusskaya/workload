package by.bntu.fitr.workload.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Data
@EqualsAndHashCode
@NoArgsConstructor
@SuperBuilder
public class MonthlyWorkloadSheetRow {
    private String subjectName;
    private LocalDate date;
    private int lecturerHours;
    private int practiseHours;
    private int laboratoryHours;
    private int consultationHours;
    private int courseworkHours;
    private int diplomaHours;
    private int setOffHours;
    private int examHours;
    private int fieldTripHours;
}
