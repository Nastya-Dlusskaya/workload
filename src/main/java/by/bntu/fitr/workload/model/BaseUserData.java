package by.bntu.fitr.workload.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Id;
import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class BaseUserData {

    private String email;
    private String firstName;
    private String lastName;
    private String patronymic;

    private Set<ObjectRef> roles;

    public String getFullName(){
        return String.format("%s %s %s", lastName, firstName, patronymic);
    }
}