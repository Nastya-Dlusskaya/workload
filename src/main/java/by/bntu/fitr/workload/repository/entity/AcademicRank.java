package by.bntu.fitr.workload.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.TableGenerator;

@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class AcademicRank implements NamedEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "rank_generator")
    @TableGenerator(table = "sequence", name = "degree_generator", allocationSize = 1)
    private Long id;
    private String name;
}
