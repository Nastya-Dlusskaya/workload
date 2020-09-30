package by.bntu.fitr.workload.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "student_group")
public class Group implements Base2 {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "group_generator")
    @TableGenerator(table = "sequence", name = "group_generator")
    private Long id;
    private String name;
}
