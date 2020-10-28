package by.bntu.fitr.workload.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Workload implements NamedEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "workload_generator")
    @TableGenerator(table = "sequence", name = "workload_generator", allocationSize = 1)
    private Long id;
    private String name;
    private String type;

    @ManyToOne
    private Subject subject;
    private int amountHours;
    private LocalDate startDate;
    private LocalDate endDate;
    private String resultType;
    private Boolean isApproved;
    private String notes;

    @ManyToOne
    private Lecturer lecturer;

    @ManyToOne
    private Plan plan;

    private Boolean isPlanned;
}
