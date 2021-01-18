package by.bntu.fitr.workload.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class EducationWorkloadSheetRow {
    private String subjectName;
    private String facultyName;
    private String specialityName;
    private List<EducationWorkloadSheetItem> items;
}
