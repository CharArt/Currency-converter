package com.ccon.chap.controller;

import com.ccon.chap.entity.ValCurs;
import com.ccon.chap.service.datetime.CustomDateTimeService;
import com.ccon.chap.service.parcer.ParcerService;
import com.ccon.chap.service.valcurs.ValCursService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;

@Controller
public class ConvertorController {
    private CustomDateTimeService customDateTimeService;
    private ValCursService valCursService;
    private ParcerService parcerService;

    @Autowired
    public ConvertorController(CustomDateTimeService customDateTimeService, ValCursService valCursService, ParcerService parcerService) {
        this.customDateTimeService = customDateTimeService;
        this.valCursService = valCursService;
        this.parcerService = parcerService;
    }

    @GetMapping("/Convertor")
    public String FrontPage(ModelMap modelMap) {
        List<ValCurs> valCursList = valCursService.findValCursByDate(LocalDateTime.of(2002,05,02,0,0));
        modelMap.addAttribute("valCursList", valCursList);
        ValCurs valCursForm = new ValCurs();
        modelMap.addAttribute("valCursForm1",valCursForm);
        modelMap.addAttribute("valCursForm2",valCursForm);
        return "Convertor";
    }

    @PostMapping("/Convertor")
    public String ValCursWork (@ModelAttribute("valCursForm1")@Valid ValCurs valCurs1, @ModelAttribute("valCursForm2")@Valid ValCurs valCurs2,ModelMap modelMap, BindingResult bindingResult){
        List<ValCurs> valCursList = valCursService.findValCursByDate(valCurs1.getCurrency_date());
            for(ValCurs valCurs3 : valCursList){
                if(valCurs3)
            }
        return "Convertor";
    }
}
