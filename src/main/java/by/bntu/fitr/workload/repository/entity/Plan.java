package by.bntu.fitr.workload.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.TableGenerator;
import java.time.LocalDate;

@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Plan implements Base {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "plan_generator")
    @TableGenerator(table = "sequence", name = "plan_generator")
    private Long id;

    @ManyToOne
    private Lecturer lecturer;

    @ManyToOne
    private Department department;

    private LocalDate startDate;
    private LocalDate endDate;
    private LocalDate approvedDate;
}
