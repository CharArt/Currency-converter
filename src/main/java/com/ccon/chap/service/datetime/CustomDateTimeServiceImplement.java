package com.ccon.chap.service.datetime;

import com.ccon.chap.repository.ValCursRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@Transactional
public class CustomDateTimeServiceImplement implements CustomDateTimeService {

  private final ValCursRepository repository;
    @Autowired
    public CustomDateTimeServiceImplement(ValCursRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<LocalDateTime> getListOfDates(LocalDateTime firstDate) {
        LocalDate start = firstDate.toLocalDate();
        LocalDate end = LocalDate.now();
        Stream<LocalDate> dates = start.datesUntil(end.plusDays(1));
        List<LocalDate> listDate = dates.collect(Collectors.toList());
        List<LocalDateTime> localDateTimes = listDate.stream().map(LocalDate::atStartOfDay).collect(Collectors.toList());
        return localDateTimes;
    }

    @Override
    public List<LocalDateTime> getListOfDatesFromLastDate() {
        LocalDate start = repository.lastEntry().getCurrency_date().toLocalDate();
        LocalDate end = LocalDate.now();
        Stream<LocalDate> dates = start.datesUntil(end.plusDays(1));
        List<LocalDate> listDate = dates.collect(Collectors.toList());
        List<LocalDateTime> localDateTimes = listDate.stream().map(LocalDate::atStartOfDay).collect(Collectors.toList());
        return localDateTimes;
    }

    @Override
    public boolean checkLastDate() {
        try {
            LocalDateTime today = LocalDate.now(ZoneId.systemDefault()).atStartOfDay();
            LocalDateTime lastDayOutOfDataBase = repository.lastEntry().getCurrency_date();
            if (today != lastDayOutOfDataBase) return false;
            else return true;
        } catch (DateTimeException exception) {
            exception.printStackTrace();
        }
        return false;
    }
}
