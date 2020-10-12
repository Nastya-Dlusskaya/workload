package by.bntu.fitr.workload.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.*;

@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Speciality implements NamedEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "spec_generator")
    @TableGenerator(table = "sequence", name = "spec_generator", allocationSize = 1)
    private Long id;
    private String name;

    @ManyToOne
    private Department department;
}
