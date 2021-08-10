package com.ccon.chap.service.history;

import com.ccon.chap.dto.view.HistoryView;
import com.ccon.chap.entity.History;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class HistoryViewServiceImplement implements HistroyViewService {

    @Override
    public List<HistoryView> setListViewFromHistory(List<HistoryView> historyViewList, List<History> historyList) {
        for (int i = 0; i < historyList.size(); i++) {
            HistoryView newHistoryView = new HistoryView();
            newHistoryView.setRequest_id(historyList.get(i).getRequest_id());
            newHistoryView.setUserName(historyList.get(i).getUser().getUser_name());
            newHistoryView.setCurrencyNameFrom(historyList.get(i).getWriteInId().getCurrency_name());
            newHistoryView.setCurrencyValueFrom(historyList.get(i).getWriteInId().getCurrency_value());
            newHistoryView.setCurrencyValueTo(historyList.get(i).getWriteOfId().getCurrency_value());
            newHistoryView.setCurrencyNameTo(historyList.get(i).getWriteOfId().getCurrency_name());
            newHistoryView.setDate_valcurs(Date.valueOf(historyList.get(i).getDate_valcurs().toLocalDate()));
            newHistoryView.setDate_conversion(Date.valueOf(historyList.get(i).getDate_conversion().toLocalDate()));
            historyViewList.add(newHistoryView);
        }
        return historyViewList;
    }
}
