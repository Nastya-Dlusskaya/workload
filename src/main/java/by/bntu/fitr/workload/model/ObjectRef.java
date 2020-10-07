package by.bntu.fitr.workload.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class ObjectRef {
    private Long id;
    private String name;

    public ObjectRef(Long id) {
        this.id = id;
    }

    public ObjectRef(String name) {
        this.name = name;
    }
}
