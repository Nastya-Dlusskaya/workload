package by.bntu.fitr.workload.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Stream implements NamedEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "stream_generator")
    @TableGenerator(table = "sequence", name = "stream_generator", allocationSize = 1)
    private Long id;
    private String name;

    @OneToMany
    private List<Group> groups;
}
