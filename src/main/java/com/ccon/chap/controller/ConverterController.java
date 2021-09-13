package com.ccon.chap.controller;

import com.ccon.chap.dto.view.ValCursView;
import com.ccon.chap.entity.User;
import com.ccon.chap.entity.ValCurs;
import com.ccon.chap.service.conversion.ConverterService;
import com.ccon.chap.service.user.UserService;
import com.ccon.chap.service.valcurs.ValCursService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Controller
public class ConverterController {
    private ValCursService valCursService;
    private ConverterService converterService;
    private UserService userService;

    @Autowired
    public ConverterController(ValCursService valCursService, ConverterService converterService, UserService userService) {
        this.valCursService = valCursService;
        this.converterService = converterService;
        this.userService = userService;
    }

    @GetMapping("/converter")
    public String FrontPage(ModelMap modelMap) {
        LocalDate localDate = LocalDate.now();
        if (!localDate.equals(valCursService.getLastEntry().getCurrency_date().toLocalDate()) && valCursService.getLastEntry().getCurrency_name().equals("Российский рубль")) {
            valCursService.fillingInDatabaseValCura();
        }
        if (!localDate.equals(valCursService.getLastEntry().getCurrency_date().toLocalDate()) && !valCursService.getLastEntry().getCurrency_name().equals("Российский рубль")) {
            valCursService.updateDatabaseValCura();
        }
        List<ValCurs> valCursList = valCursService.findValCursByDate(valCursService.getLastEntry().getCurrency_date());
        modelMap.addAttribute("valCursList", valCursList);

        ValCursView valCursView = new ValCursView();
        modelMap.addAttribute("valCursView", valCursView);
        return "converter";
    }

    @PostMapping("/converter")
    public String ValCursWork(@ModelAttribute("valCursView") ValCursView valCursView, ModelMap modelMap, Principal principal) {
        User user = userService.findByUserLogin(principal.getName());

        LocalDate localDate = LocalDate.parse(new SimpleDateFormat("yyyy-MM-dd").format(valCursView.getTimeSearch()));
        LocalTime localTime = LocalTime.of(0, 0);
        LocalDateTime localDateTime = LocalDateTime.of(localDate, localTime);

        List<ValCurs> valCursList = valCursService.findValCursByDate(localDateTime);

        modelMap.addAttribute("valCursView", converterService.conversion(valCursList, valCursView, user));
        modelMap.addAttribute("valCursList", valCursList);
        return "converter";
    }
}
