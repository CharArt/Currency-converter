package com.ccon.chap.service.history;

import com.ccon.chap.dto.view.HistoryView;
import com.ccon.chap.entity.History;

import java.util.List;

public interface HistoryViewService {
    public List<HistoryView> setListViewFromHistory(List<History> historyList);
}