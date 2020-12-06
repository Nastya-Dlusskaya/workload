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
public class Position implements NamedEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "position_generator")
    @TableGenerator(table = "sequence", name = "position_generator", allocationSize = 1)
    private Long id;
    private String name;
}
