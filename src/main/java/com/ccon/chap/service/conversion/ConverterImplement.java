package com.ccon.chap.service.conversion;

import com.ccon.chap.dto.view.ValCursView;
import com.ccon.chap.entity.History;
import com.ccon.chap.entity.User;
import com.ccon.chap.entity.ValCurs;
import com.ccon.chap.service.history.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class ConverterImplement implements ConverterService {
    private HistoryService historyService;

    @Autowired
    public ConverterImplement(HistoryService historyService) {
        this.historyService = historyService;
    }

    @Override
    public ValCursView conversion(List<ValCurs> valCursList, ValCursView valCursView, User user) {
        ValCurs from = new ValCurs();
        ValCurs to = new ValCurs();

        History history = new History(from, to, user, from.getCurrency_date(), LocalDateTime.now());
        historyService.saveHistory(history);

        for (ValCurs valCurs : valCursList) {
            if (valCursView.getNameValuteOne().equals(valCurs.getCurrency_name())) {
                from = valCurs;
            }
            if (valCursView.getNameValuteTwo().equals(valCurs.getCurrency_name())) {
                to = valCurs;
            }
        }

        if (valCursView.getValueValuteTwo().isEmpty()) {
            float valueOne = Float.parseFloat(valCursView.getValueValuteOne());
            float answer = (valueOne * Float.parseFloat(from.getCurrency_value())) / Float.parseFloat(to.getCurrency_value());
            valCursView.setValueValuteTwo(String.valueOf(answer));
            return valCursView;
        }

        if (valCursView.getValueValuteOne().isEmpty()) {
            float valueTwo = Float.parseFloat(valCursView.getValueValuteTwo());
            float answer = (valueTwo * Float.parseFloat(to.getCurrency_value())) / Float.parseFloat(from.getCurrency_value());
            valCursView.setValueValuteTwo(String.valueOf(answer));
            return valCursView;
        }
        return valCursView;
    }
}
