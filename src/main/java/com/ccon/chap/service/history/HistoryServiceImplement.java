package com.ccon.chap.service.history;

import com.ccon.chap.entity.History;
import com.ccon.chap.repository.HistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class HistoryServiceImplement implements HistoryService {

    private HistoryRepository repository;

    @Autowired
    public HistoryServiceImplement(HistoryRepository historyRepository) {
        this.repository = historyRepository;
    }

    @Override
    public History findHistoryByRequestId(Long requestId) {
        return repository.getOne(requestId);
    }

    @Override
    public List<History> findHistoryByWriteOfId(Long writeOfId) {
        return repository.findHistoryByWriteOfId(writeOfId);
    }

    @Override
    public List<History> findHistoryByWriteInId(Long writeInId) {
        return repository.findHistoryByWriteInId(writeInId);
    }

    @Override
    public List<History> findHistoryByUserId(Long userId) {
        return repository.findHistoryByUserId(userId);
    }

    @Override
    public List<History> findHistoryByDateConversion(LocalDateTime dateConversion) {
        return repository.findHistoryByDateConversion(dateConversion);
    }

    @Override
    public List<History> findAll() {
        return repository.findAll();
    }

    @Override
    public void saveHistory(History history) {
        repository.save(history);
    }

    @Override
    public void deleteHistoryByRequestId(Long requestId) {
        repository.deleteHistoryById(requestId);
    }
}
