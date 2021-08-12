package com.ccon.chap.service.history;

import com.ccon.chap.dto.view.HistoryView;
import com.ccon.chap.entity.History;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Service
public class HistoryViewServiceImplement implements HistoryViewService {

    @Override
    public List<HistoryView> setListViewFromHistory(List<History> historyList) {
        List<HistoryView> historyViewList = new ArrayList<>();
        for (History history : historyList) {
            HistoryView newHistoryView = new HistoryView();
            newHistoryView.setUserName(history.getUser().getUser_name());
            newHistoryView.setCurrencyOfName(history.getWritOfId().getCurrency_name());
            newHistoryView.setCurrencyOfValue(history.getWritOfId().getCurrency_value());
            newHistoryView.setCurrencyInValue(history.getWriteInId().getCurrency_value());
            newHistoryView.setCurrencyInName(history.getWriteInId().getCurrency_name());
            newHistoryView.setDate_valcurs(Date.valueOf(history.getDateValcurs().toLocalDate()));
            newHistoryView.setDate_conversion(Date.valueOf(history.getDateConversion().toLocalDate()));
            historyViewList.add(newHistoryView);
        }
        return historyViewList;
    }
}
