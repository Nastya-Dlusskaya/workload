package by.bntu.fitr.workload.model;

import lombok.*;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EducationWorkloadSheetItem {
    private String name;
    private int expected;
    private int actual;
}
