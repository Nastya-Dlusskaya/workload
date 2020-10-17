package by.bntu.fitr.workload.service;

import by.bntu.fitr.workload.converter.RoleConverter;
import by.bntu.fitr.workload.exception.NotFoundException;
import by.bntu.fitr.workload.model.BaseUserData;
import by.bntu.fitr.workload.model.UserDto;
import by.bntu.fitr.workload.repository.dataaccess.LecturerRepository;
import by.bntu.fitr.workload.repository.dataaccess.UserRepository;
import by.bntu.fitr.workload.repository.entity.Lecturer;
import by.bntu.fitr.workload.repository.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private RoleConverter roleConverter;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private LecturerRepository lecturerRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = repository.findById(email).orElseThrow(NotFoundException::new);
        UserDto userDto = new UserDto();
        userDto.setPassword(user.getPassword());
        userDto.setEmail(user.getEmail());
        userDto.setRoles(roleConverter.convertToDtoSet(user.getRoles()));
        return userDto;
    }

    public BaseUserData findByEmail(String email) {
        UserDto userDto = (UserDto) loadUserByUsername(email);
        BaseUserData baseUserData = new BaseUserData();
        baseUserData.setEmail(userDto.getUsername());
        baseUserData.setRoles(userDto.getRoles());

        Lecturer lecturer = lecturerRepository.findByEmail(email);
        baseUserData.setFirstName(lecturer.getName());
        baseUserData.setLastName(lecturer.getSurname());
        baseUserData.setPatronymic(lecturer.getPatronymic());

        return baseUserData;
    }

}
