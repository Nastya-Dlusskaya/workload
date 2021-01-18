package by.bntu.fitr.workload.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class GroupDto extends ObjectRef {

    private int studentCount;
    private SpecialityDto speciality;
    private int course;
    private StreamDto stream;
}
