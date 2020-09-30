package by.bntu.fitr.workload.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class LecturerDto {

    private String surname;
    private String name;
    private String patronymic;
    private String email;

    private ObjectRef academicDegree;

    private ObjectRef academicRank;
}
