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
@javax.persistence.Entity
public class Lecturer implements Entity, NamedEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "lecturer_generator")
    @TableGenerator(table = "sequence", name = "lecturer_generator", allocationSize = 1)
    private Long id;
    private String surname;
    private String name;
    private String patronymic;
    @Column(unique = true)
    private String email;

    @ManyToOne
    private AcademicDegree academicDegree;

    @ManyToOne
    private AcademicRank academicRank;
}
