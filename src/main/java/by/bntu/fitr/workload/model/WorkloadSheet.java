package by.bntu.fitr.workload.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public abstract class WorkloadSheet {
    private String name;

    public abstract List<String> getHeader();

    public abstract String getType();
}
