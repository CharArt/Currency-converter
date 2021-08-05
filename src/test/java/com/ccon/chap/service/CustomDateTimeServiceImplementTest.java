package com.ccon.chap.service;

import com.ccon.chap.configurations.JpaConfiguration;
import com.ccon.chap.service.datetime.CustomDateTimeService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = JpaConfiguration.class)
@WebAppConfiguration
@Transactional
public class CustomDateTimeServiceImplementTest {

    private CustomDateTimeService service;

    @Autowired
    public CustomDateTimeServiceImplementTest(CustomDateTimeService service) {
        this.service = service;
    }

    @Test
    public void getListOfDatesTest() {
        LocalDateTime firstDate = LocalDateTime.of(1993, Month.FEBRUARY, 10, 0, 0);
        List<LocalDateTime> listDates = service.getListOfDates(firstDate);
        assertNotNull(listDates);
    }

    @Test
    public void getListOfDatesFromLastDateTest() {
        List<LocalDateTime> listDates = service.getListOfDatesFromLastDate();
        assertNotNull(listDates);
    }

    @Test
    public void checkLastDate() {
        assertFalse(service.checkLastDate());
    }
}
