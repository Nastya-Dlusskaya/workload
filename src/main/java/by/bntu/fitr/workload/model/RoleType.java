package by.bntu.fitr.workload.model;

import java.util.Arrays;
import java.util.Optional;

public enum RoleType {
    ADMIN(1L, "ADMIN"),
    LECTURER(2L, "LECTURER");

    private Long id;
    private String role;

    RoleType(Long id, String role) {
        this.id = id;
        this.role = role;
    }

    public ObjectRef get() {
        return new ObjectRef(id, role);
    }

    public Long getId() {
        return id;
    }

    public String getRole() {
        return role;
    }

    public ObjectRef find(Long toFindId) {
        Optional<RoleType> role = Arrays.stream(RoleType.values()).filter(r -> r.id.equals(toFindId)).findFirst();
        return role.map(roleConstant -> new ObjectRef(roleConstant.id, roleConstant.role)).orElse(null);
    }

    public ObjectRef find(String toFindRole) {
        Optional<RoleType> role = Arrays.stream(RoleType.values()).filter(r -> r.role.equals(toFindRole)).findFirst();
        return role.map(roleConstant -> new ObjectRef(roleConstant.id, roleConstant.role)).orElse(null);
    }
}
