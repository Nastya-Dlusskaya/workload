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

@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Department implements Base2 {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "department_generator")
    @TableGenerator(table = "sequence", name = "department_generator")
    private Long id;
    private String name;

    @ManyToOne
    private Faculty faculty;
}
