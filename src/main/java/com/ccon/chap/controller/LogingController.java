package com.ccon.chap.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LogingController {

    @GetMapping("/")
    public String LoginPage(ModelMap modelMap) {
        return "Loging";
    }
}