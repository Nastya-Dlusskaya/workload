package by.bntu.fitr.workload.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "department_generator")
    @TableGenerator(table = "sequence", name = "department_generator")
    private Long id;
    private String name;

    @ManyToOne
    private Faculty faculty;
}
