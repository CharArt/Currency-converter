package com.ccon.chap.service.history;

import com.ccon.chap.entity.History;

import java.time.LocalDateTime;
import java.util.List;

public interface HistoryService {

    History findHistoryByRequestId(Long requestId);

    List<History> findHistoryByWriteOfId(Long writeOfId);

    List<History> findHistoryByWriteInId(Long writeInId);

    List<History> findHistoryByUserId(Long userId);

    List<History> findHistoryByDateConversion (LocalDateTime dateConversion);

    List<History> findAll();

    void saveHistory (History history);

    void deleteHistoryByRequestId (Long requestId);
}
