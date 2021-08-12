package com.ccon.chap.controller;

import com.ccon.chap.dto.view.HistoryView;
import com.ccon.chap.entity.History;
import com.ccon.chap.service.history.HistoryService;
import com.ccon.chap.service.history.HistoryViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class HistoryController {
    private HistoryService historyService;
    private HistoryViewService historyViewService;

    @Autowired
    public HistoryController(HistoryService historyService, HistoryViewService historyViewService) {
        this.historyService = historyService;
        this.historyViewService = historyViewService;
    }

    @GetMapping("/History")
    public String getHistoryUser(Model model) {
        List<History> historyList = historyService.findHistoryByUserId(2L);

        List<HistoryView> historyViewList = historyViewService.setListViewFromHistory(historyList);

        model.addAttribute("historyViewList", historyViewList);
        HistoryView historyView = new HistoryView();

        model.addAttribute("history", historyView);
        return "History";
    }

    @PostMapping("/History")
    public String getRequiredField(@ModelAttribute("history") HistoryView historyView, Model model) {
        List<History> historyList = historyService.findHistoryByUserId(2L);

        List<HistoryView> historyViewList = historyViewService.setListViewFromHistory(historyList);

        if (historyView.getCurrencyOfName().isEmpty() &&
                historyView.getCurrencyOfValue().isEmpty() &&
                historyView.getCurrencyInValue().isEmpty() &&
                historyView.getCurrencyInName().isEmpty() &&
                null != historyView.getDate_valcurs() &&
                null != historyView.getDate_conversion()) {
            model.addAttribute("historyViewList", historyViewList);
            return "History";
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
        return "History";
    }
}
