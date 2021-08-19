package com.ccon.chap.controller;

import com.ccon.chap.entity.User;
import com.ccon.chap.service.user.UserService;
import com.ccon.chap.validation.UserCustomValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.time.LocalDateTime;

@Controller
public class RegistrationController {

    private UserService userService;
    private UserCustomValidation userCustomValidation;

    @Autowired
    public RegistrationController(UserService userService, UserCustomValidation userCustomValidation) {
        this.userService = userService;
        this.userCustomValidation = userCustomValidation;
    }

    @InitBinder
    protected void initBinder(final WebDataBinder webDataBinder) {
        webDataBinder.addValidators(userCustomValidation);

    }

    @GetMapping("/registration")
    public String FrontPage(ModelMap modelMap) {
        User newUser = new User();
        modelMap.addAttribute("user", newUser);
        return "registration";
    }

    @PostMapping("/registration")
    public String checkUserInfo(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        user.setUser_created_at(LocalDateTime.now());
        user.setUser_is_active(true);
        if (bindingResult.hasErrors()) {
            return "registration";
        }
        userService.createdNewUser(user);
        return "redirect:/login";
    }
}
