package by.bntu.fitr.workload.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class LecturerDto extends ObjectRef {

    private String surname;
    private String patronymic;
    private String email;
    private String homePhone;
    private String mobilePhone;
    private String workPhone;
    private String skype;
    private Boolean staff;
    private Boolean budget;
    private Boolean hourPaid;

    private ObjectRef academicDegree;

    private ObjectRef academicRank;

    private ObjectRef position;

    public String getFullName() {
        return surname + " " + getName() + " " + patronymic;
    }
}
