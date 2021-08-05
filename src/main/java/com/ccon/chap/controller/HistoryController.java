package com.ccon.chap.controller;

import com.ccon.chap.dto.HistoryView;
import com.ccon.chap.entity.History;
import com.ccon.chap.service.history.HistoryService;
import com.ccon.chap.service.history.HistoryViewServiceImplement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class HistoryController {
    private HistoryService historyService;
    private HistoryViewServiceImplement historyViewServiceImplement;

    @Autowired
    public HistoryController(HistoryService historyService, HistoryViewServiceImplement historyViewServiceImplement) {
        this.historyService = historyService;
        this.historyViewServiceImplement = historyViewServiceImplement;
    }

    @GetMapping("/History")
    public String getHistoryUser(Model model) {
        List<History> historyList = historyService.findHistoryByUserId(2L);
        List<HistoryView> historyViewList = new ArrayList<HistoryView>(historyList.size());
        historyViewList = historyViewServiceImplement.setListViewFromHistory(historyViewList, historyList);
        model.addAttribute("historyViewList", historyViewList);
        HistoryView historyView = new HistoryView();
        model.addAttribute("history", historyView);
        return "History";
    }

    @PostMapping("/History")
    public String getRequiredField(@ModelAttribute("history") HistoryView historyView, Model model) {
        List<History> historyList = historyService.findHistoryByUserId(2L);
        List<HistoryView> historyViewList = new ArrayList<HistoryView>(historyList.size());
        historyViewList = historyViewServiceImplement.setListViewFromHistory(historyViewList, historyList);
        if (historyView.getCurrencyNameFrom().isEmpty() && historyView.getCurrencyValueFrom().isEmpty() && historyView.getCurrencyValueTo().isEmpty() && historyView.getCurrencyNameTo().isEmpty() && null == historyView.getDate_valcurs() && null == historyView.getDate_conversion()) {
            model.addAttribute("historyViewList", historyViewList);
            return "History";
        }
        if (!historyView.getCurrencyNameFrom().isEmpty()) {
            historyViewList = historyViewList.stream().filter(historyView1 -> !historyView1.getCurrencyNameFrom().isEmpty() && historyView1.getCurrencyNameFrom().equals(historyView.getCurrencyNameFrom())).collect(Collectors.toList());
        }
        if (!historyView.getCurrencyValueFrom().isEmpty()) {
            historyViewList = historyViewList.stream().filter(historyView1 -> !historyView1.getCurrencyValueFrom().isEmpty() && historyView1.getCurrencyValueFrom().equals(historyView.getCurrencyValueFrom())).collect(Collectors.toList());
        }
        if (!historyView.getCurrencyValueTo().isEmpty()) {
            historyViewList = historyViewList.stream().filter(historyView1 -> !historyView1.getCurrencyValueTo().isEmpty() && historyView1.getCurrencyValueTo().equals(historyView.getCurrencyValueTo())).collect(Collectors.toList());
        }
        if (!historyView.getCurrencyNameTo().isEmpty()) {
            historyViewList = historyViewList.stream().filter(historyView1 -> !historyView1.getCurrencyNameTo().isEmpty() && historyView1.getCurrencyNameTo().equals(historyView.getCurrencyNameTo())).collect(Collectors.toList());
        }
        if (null != historyView.getDate_valcurs()) {
            historyViewList = historyViewList.stream().filter(historyView1 -> historyView1.getDate_valcurs() != null && historyView1.getDate_valcurs().equals(historyView.getDate_valcurs())).collect(Collectors.toList());
        }
        if (null != historyView.getDate_conversion()) {
            historyViewList = historyViewList.stream().filter(historyView1 -> historyView1.getDate_conversion() != null && historyView1.getDate_conversion().equals(historyView.getDate_conversion())).collect(Collectors.toList());
        }
        model.addAttribute("historyViewList", historyViewList);
        return "History";
    }
}
