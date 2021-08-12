package com.ccon.chap.service.conversion;

import com.ccon.chap.dto.view.ValCursView;
import com.ccon.chap.entity.History;
import com.ccon.chap.entity.User;
import com.ccon.chap.entity.ValCurs;
import com.ccon.chap.service.history.HistoryService;
import com.ccon.chap.service.user.UserService;
import com.ccon.chap.service.valcurs.ValCursService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class ConverterImplement implements ConverterService {
    private HistoryService historyService;
    private ValCursService valCursService;
    private UserService userService;

    @Autowired
    public ConverterImplement(HistoryService historyService, ValCursService valCursService, UserService userService) {
        this.historyService = historyService;
        this.valCursService = valCursService;
        this.userService = userService;
    }

    @Override
    public ValCursView conversion(List<ValCurs> valCursList, ValCursView valCursView, User user) {
        ValCurs currencyOf = new ValCurs();
        ValCurs currencyIn = new ValCurs();


        for (ValCurs valCurs : valCursList) {
            if (valCursView.getNameValuteOne().equals(valCurs.getCurrency_name())) {
                currencyOf = valCurs;
            }
            if (valCursView.getNameValuteTwo().equals(valCurs.getCurrency_name())) {
                currencyIn = valCurs;
            }
        }
        History history = new History(currencyOf.getCurrency_date(),
                LocalDateTime.now(),
                valCursService.findValCursByWriteId(currencyOf.getWrite_id()),
                valCursService.findValCursByWriteId(currencyIn.getWrite_id()),
                userService.findByUserId(user.getUser_id()));
        historyService.saveHistory(history);

        if (valCursView.getValueValuteTwo().isEmpty()) {
            float valueOne = Float.parseFloat(valCursView.getValueValuteOne());
            float answer = (valueOne * Float.parseFloat(currencyOf.getCurrency_value())) / Float.parseFloat(currencyIn.getCurrency_value());
            valCursView.setValueValuteTwo(String.valueOf(answer));
            return valCursView;
        }

        if (valCursView.getValueValuteOne().isEmpty()) {
            float valueTwo = Float.parseFloat(valCursView.getValueValuteTwo());
            float answer = (valueTwo * Float.parseFloat(currencyIn.getCurrency_value())) / Float.parseFloat(currencyOf.getCurrency_value());
            valCursView.setValueValuteOne(String.valueOf(answer));
            return valCursView;
        }
        return valCursView;
    }
}
