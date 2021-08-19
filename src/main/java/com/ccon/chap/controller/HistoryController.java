package com.ccon.chap.controller;

import com.ccon.chap.dto.view.HistoryView;
import com.ccon.chap.entity.History;
import com.ccon.chap.service.history.HistoryService;
import com.ccon.chap.service.history.HistoryViewService;
import com.ccon.chap.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class HistoryController {
    private HistoryService historyService;
    private HistoryViewService historyViewService;
    private UserService userService;

    @Autowired
    public HistoryController(HistoryService historyService, HistoryViewService historyViewService, UserService userService) {
        this.historyService = historyService;
        this.historyViewService = historyViewService;
        this.userService = userService;
    }

    @GetMapping("/history")
    public String getHistoryUser(Model model, Principal principal) {
        List<History> historyList = historyService.findHistoryByUserId(userService.findByUserLogin(principal.getName()).getUser_id());

        List<HistoryView> historyViewList = historyViewService.setListViewFromHistory(historyList);

        model.addAttribute("historyViewList", historyViewList);
        HistoryView historyView = new HistoryView();

        model.addAttribute("histor", historyView);
        return "history";
    }

    @PostMapping("/history")
    public String getRequiredField(@ModelAttribute("histor") HistoryView historyView, Model model, Principal principal) {
        List<History> historyList = historyService.findHistoryByUserId(userService.findByUserLogin(principal.getName()).getUser_id());
        List<HistoryView> historyViewList = historyViewService.setListViewFromHistory(historyList);

        if (historyView.getCurrencyOfName().isEmpty() &&
                historyView.getCurrencyOfValue().isEmpty() &&
                historyView.getCurrencyInValue().isEmpty() &&
                historyView.getCurrencyInName().isEmpty() &&
                null != historyView.getDate_valcurs() &&
                null != historyView.getDate_conversion()) {
            model.addAttribute("historyViewList", historyViewList);
            return "history";
        }
        if (!historyView.getCurrencyOfName().isEmpty()) {
            historyViewList = historyViewList.stream().filter(historyView1 -> !historyView1.getCurrencyOfName().isEmpty() && historyView1.getCurrencyOfName().equals(historyView.getCurrencyOfName())).collect(Collectors.toList());
        }
        if (!historyView.getCurrencyOfValue().isEmpty()) {
            historyViewList = historyViewList.stream().filter(historyView1 -> !historyView1.getCurrencyOfValue().isEmpty() && historyView1.getCurrencyOfValue().equals(historyView.getCurrencyOfValue())).collect(Collectors.toList());
        }
        if (!historyView.getCurrencyInValue().isEmpty()) {
            historyViewList = historyViewList.stream().filter(historyView1 -> !historyView1.getCurrencyInValue().isEmpty() && historyView1.getCurrencyInValue().equals(historyView.getCurrencyInValue())).collect(Collectors.toList());
        }
        if (!historyView.getCurrencyInName().isEmpty()) {
            historyViewList = historyViewList.stream().filter(historyView1 -> !historyView1.getCurrencyInName().isEmpty() && historyView1.getCurrencyInName().equals(historyView.getCurrencyInName())).collect(Collectors.toList());
        }
        if (null != historyView.getDate_valcurs()) {
            historyViewList = historyViewList.stream().filter(historyView1 -> null != historyView1.getDate_valcurs() && historyView1.getDate_valcurs().equals(historyView.getDate_valcurs())).collect(Collectors.toList());
        }
        if (null != historyView.getDate_conversion()) {
            historyViewList = historyViewList.stream().filter(historyView1 -> null != historyView1.getDate_conversion() && historyView1.getDate_conversion().equals(historyView.getDate_conversion())).collect(Collectors.toList());
        }
        model.addAttribute("historyViewList", historyViewList);
        return "history";
    }
}
