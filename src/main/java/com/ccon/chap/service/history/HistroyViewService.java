package com.ccon.chap.service.history;

import com.ccon.chap.dto.HistoryView;
import com.ccon.chap.entity.History;

import java.util.List;

public interface HistroyViewService {

    public List<HistoryView> setListViewFromHistory (List<HistoryView> historyViewList,  List<History> historyList);

}
