package by.bntu.fitr.workload.converter;

import by.bntu.fitr.workload.model.UserDto;
import by.bntu.fitr.workload.repository.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {
    @Autowired
    private RoleConverter roleConverter;

    public User convertToEntity(UserDto userDto) {
        User entity = new User();
        entity.setEmail(userDto.getEmail());
        entity.setPassword(userDto.getPassword());
        entity.setRoles(roleConverter.convertToEntitySet(userDto.getRoles()));
        return entity;
    }

    public UserDto convertToDto(User userDto) {
        UserDto entity = new UserDto();
        entity.setEmail(userDto.getEmail());
        entity.setPassword(userDto.getPassword());
        entity.setRoles(roleConverter.convertToDtoSet(userDto.getRoles()));
        return entity;
    }
}
