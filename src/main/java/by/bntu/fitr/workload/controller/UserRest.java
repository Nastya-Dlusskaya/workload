package by.bntu.fitr.workload.controller;

import by.bntu.fitr.workload.model.BaseUserData;
import by.bntu.fitr.workload.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserRest {

    @Autowired
    private UserService service;

    @GetMapping("/data")
    public BaseUserData find(Authentication authentication) {
        if (authentication != null && StringUtils.isNotBlank(authentication.getName())) {
            return service.findByEmail(authentication.getName());
        }
        throw new RuntimeException("You dont have access to this resource.");
    }

}