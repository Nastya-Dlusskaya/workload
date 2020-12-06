package by.bntu.fitr.workload.service;

import by.bntu.fitr.workload.converter.RoleConverter;
import by.bntu.fitr.workload.converter.UserConverter;
import by.bntu.fitr.workload.exception.NotFoundException;
import by.bntu.fitr.workload.model.BaseUserData;
import by.bntu.fitr.workload.model.ObjectRef;
import by.bntu.fitr.workload.model.RoleType;
import by.bntu.fitr.workload.model.UserDto;
import by.bntu.fitr.workload.repository.dataaccess.LecturerRepository;
import by.bntu.fitr.workload.repository.dataaccess.UserRepository;
import by.bntu.fitr.workload.repository.entity.Lecturer;
import by.bntu.fitr.workload.repository.entity.Role;
import by.bntu.fitr.workload.repository.entity.User;
import by.bntu.fitr.workload.resolver.RoleResolver;
import org.apache.commons.text.CharacterPredicates;
import org.apache.commons.text.RandomStringGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Set;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private UserConverter userConverter;

    @Autowired
    private RoleConverter roleConverter;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private LecturerRepository lecturerRepository;

    @Autowired
    private EmailService emailService;

    @Autowired
    private RoleResolver roleResolver;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = repository.findById(email).orElseThrow(NotFoundException::new);
        UserDto userDto = new UserDto();
        userDto.setPassword(user.getPassword());
        userDto.setEmail(user.getEmail());
        userDto.setRoles(roleConverter.convertToDtoSet(user.getRoles()));
        return userDto;
    }

    public UserDto create(String email, RoleType role) {
        return create(email, Collections.singleton(ObjectRef.toObjectRef(role.getId(), role.getRole())));
    }

    public UserDto create(String email, Set<ObjectRef> roles) {

        String password = generatePassword();
        Set<Role> newRoles = roleResolver.resolve(roles);

        User newUser = new User();
        newUser.setEmail(email);
        newUser.setPassword(bCryptPasswordEncoder.encode(password));
        newUser.setRoles(newRoles);

        newUser = repository.save(newUser);

        sendEmail(email, password);
        return userConverter.convertToDto(newUser);
    }

    private String generatePassword() {
        RandomStringGenerator randomStringGenerator =
                new RandomStringGenerator.Builder()
                        .withinRange('0', 'z')
                        .filteredBy(CharacterPredicates.LETTERS, CharacterPredicates.DIGITS)
                        .build();
        return randomStringGenerator.generate(6, 8);
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

    private void sendEmail(String email, String password) {
        emailService.sendEmail(email, "Добро пожаловать в систему Attendance-monitor App",
                String.format("Для входа в систему используйте: " +
                                "\n\te-mail: %s " +
                                "\n\tпароль: %s" +
                                "\n\nПожалуйста, поменяйте пароль при первом использовании!",
                        email, password));
    }

}
