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
public class AcademicDegree {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "degree_generator")
    @TableGenerator(table = "sequence", name = "degree_generator")
    @TableGenerator(table = "sequence", name = "degree_generator")
private Long id;
    private String name;
}
