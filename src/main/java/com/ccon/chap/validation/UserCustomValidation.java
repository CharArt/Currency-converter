package com.ccon.chap.validation;

import com.ccon.chap.entity.User;
import com.ccon.chap.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class UserCustomValidation implements Validator {

    private UserService userService;
    private Validator basicValidator;

    @Autowired
    public UserCustomValidation(UserService userService, Validator basicValidator) {
        this.userService = userService;
        this.basicValidator = basicValidator;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;
        if (null != user.getUser_login() && userService.isPresentLogin(user.getUser_login())){
            errors.rejectValue("user_login", "NonUniq.User", "A user with this login already exists");
        }
        if (null != user.getUser_email() && userService.isPresentEmail(user.getUser_email())){
            errors.rejectValue("user_email", "NonUniq.Email", "A user with this email already exists");
        }
    }
}
