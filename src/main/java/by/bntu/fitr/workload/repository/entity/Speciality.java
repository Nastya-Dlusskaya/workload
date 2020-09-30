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
public class Speciality {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "spec_generator")
    @TableGenerator(table = "sequence", name = "spec_generator")
private Long id;
    private String name;
}
