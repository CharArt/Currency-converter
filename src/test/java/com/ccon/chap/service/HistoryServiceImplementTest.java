package com.ccon.chap.service;

import com.ccon.chap.configurations.JpaConfiguration;
import com.ccon.chap.entity.History;
import com.ccon.chap.entity.User;
import com.ccon.chap.entity.ValCurs;
import com.ccon.chap.service.history.HistoryService;
import com.ccon.chap.service.user.UserService;
import com.ccon.chap.service.valcurs.ValCursService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SqlGroup({@Sql("/sql/cleaning-data-base.sql"), @Sql("/sql/create-all-table.sql")})
@Sql(scripts = "/sql/cleaning-data-base.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
@ContextConfiguration(classes = JpaConfiguration.class)
@WebAppConfiguration
@Transactional
public class HistoryServiceImplementTest {

    private final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");

    private HistoryService historyService;
    private ValCursService valCursService;
    private UserService userService;

    @Autowired
    public HistoryServiceImplementTest(HistoryService historyService, ValCursService valCursService, UserService userService) {
        this.historyService = historyService;
        this.valCursService = valCursService;
        this.userService = userService;
    }

    @Test
    void findHistoryByRequestIdTest() {
        assertEquals(1, historyService.findHistoryByRequestId(1L).getRequest_id());
    }

    @Test
    void findHistoryByWriteOfIdTest() {
        List<History> stories = historyService.findHistoryByWriteOfId(5L);
        for (History h : stories) {
            assertEquals(5, h.getWritOfId().getWrite_id());
        }
    }

    @Test
    void findHistoryByWriteInIdTest() {
        List<History> stories = historyService.findHistoryByWriteInId(6L);
        for (History h : stories) {
            assertEquals(6, h.getWriteInId().getWrite_id());
        }
    }

    @Test
    void findHistoryByUserIdTest() {
        List<History> stories = historyService.findHistoryByUserId(1L);
        for (History h : stories) {
            assertEquals(1, h.getUser().getUser_id());
        }
    }

    @Test
    void findHistoryByDateConversionTest() {
        Calendar calendar = new GregorianCalendar(2020, Calendar.DECEMBER, 30, 19, 2, 48);
        LocalDateTime localDateTime = LocalDateTime.ofInstant(calendar.toInstant(), ZoneId.systemDefault());
        List<History> stories = historyService.findHistoryByDateConversion(localDateTime);
        for (History h : stories) {
            assertEquals(localDateTime.format(TIME_FORMATTER), h.getDateConversion().format(TIME_FORMATTER));
        }
    }

    @Test
    void createdNewHistoryTest() {
        ValCurs valCursOf = valCursService.findValCursByWriteId(3L);
        ValCurs valCursIn = valCursService.findValCursByWriteId(6L);
        User user = userService.findByUserId(1L);
        LocalDateTime now = LocalDateTime.now();

        History history = new History(valCursOf.getCurrency_date(), LocalDateTime.now(), valCursOf, valCursIn, user);
        historyService.saveHistory(history);

        assertEquals(31, historyService.findAll().size());
    }

    @Test
    void deleteHistoryByRequestIdTest() {
        historyService.deleteHistoryByRequestId(30L);
        assertEquals(29, historyService.findAll().size());
    }
}
