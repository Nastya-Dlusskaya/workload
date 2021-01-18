package by.bntu.fitr.workload.model;

import lombok.*;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Book {
    private String name;
    private List<WorkloadSheet> workloadSheets;
}
