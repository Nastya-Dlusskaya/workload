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
public class Plan implements NamedEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "plan_generator")
    @TableGenerator(table = "sequence", name = "plan_generator", allocationSize = 1)
    private Long id;
    private String name;

    @ManyToOne
    private Lecturer lecturer;

    private LocalDate startDate;
    private LocalDate endDate;
    private LocalDate approvedDate;
}
