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
@Table(name = "student_group")
public class Group implements NamedEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "group_generator")
    @TableGenerator(table = "sequence", name = "group_generator", allocationSize = 1)
    private Long id;
    private String name;
    private int studentCount;

    @ManyToOne
    private Speciality speciality;

    @ManyToOne
    private Stream stream;
}
