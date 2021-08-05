package com.ccon.chap.service.datetime;

import java.time.LocalDateTime;
import java.util.List;

public interface CustomDateTimeService {

    List<LocalDateTime> getListOfDates(LocalDateTime firstDate);

    List<LocalDateTime> getListOfDatesFromLastDate();

    boolean checkLastDate();
}
