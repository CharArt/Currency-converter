package com.ccon.chap.service;

import com.ccon.chap.configurations.JpaConfiguration;
import com.ccon.chap.entity.ValCurs;
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
@SqlGroup({@Sql("/sql/cleaning-data-base.sql"), @Sql("/sql/create-valcurs-table.sql")})
@Sql(scripts = "/sql/cleaning-data-base.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
@ContextConfiguration(classes = JpaConfiguration.class)
@WebAppConfiguration
@Transactional
public class ValCursServiceImplementTest {
    private final DateTimeFormatter DATA_TIME_VALCURS = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    private ValCursService valCursService;

    @Autowired
    public ValCursServiceImplementTest(ValCursService valCursService) {
        this.valCursService = valCursService;
    }

    @Test
    void findValCursByWriteIdTest() {
        assertEquals(1, valCursService.findValCursByWriteId(1L).getWrite_id());
    }

    @Test
    void findValCursByCurrencyIdTest() {
        List<ValCurs> valCurs = valCursService.findValCursByCurrencyId("R01035");
        for (ValCurs v : valCurs) {
            assertEquals("R01035", v.getCurrency_id());
        }
    }

    @Test
    void findValCursByNumCodeTest() {
        short numcode = 826;
        List<ValCurs> valCurs = valCursService.findValCursByNumCode(numcode);
        for (ValCurs v : valCurs) {
            assertEquals(826, v.getCurrency_numcode());
        }
    }

    @Test
    void findByCharCodeTest() {
        List<ValCurs> valCurs = valCursService.findByCharCode("GBP");
        for (ValCurs v : valCurs) {
            assertEquals("GBP", v.getCurrency_charcode());
        }
    }

    @Test
    void findValCursByNameTest() {
        List<ValCurs> valCurs = valCursService.findValCursByName("Фунт стерлингов Соединенного королевства");
        for (ValCurs v : valCurs) {
            assertEquals("Фунт стерлингов Соединенного королевства", v.getCurrency_name());
        }
    }

    @Test
    void findValCursByDateTest() {
        Calendar calendar = new GregorianCalendar(2002, Calendar.APRIL, 2);
        LocalDateTime localDateTime = LocalDateTime.ofInstant(calendar.toInstant(), ZoneId.systemDefault());
        List<ValCurs> valCurs = valCursService.findValCursByDate(localDateTime);
        for (ValCurs v : valCurs) {
            assertEquals(localDateTime.format(DATA_TIME_VALCURS), v.getCurrency_date().format(DATA_TIME_VALCURS));
        }
    }

    @Test
    void createdNewValCursTest() {
        Calendar calendar = new GregorianCalendar(2002, Calendar.JUNE, 2);
        LocalDateTime localDateTime = LocalDateTime.ofInstant(calendar.toInstant(), ZoneId.systemDefault());
        short numcode = 999;

        ValCurs newv = new ValCurs("R99999", numcode, "AAA", 1, "Артёмий", "100.0100", localDateTime);
        valCursService.createdNewValCurs(newv);

        assertEquals(53, valCursService.findAll().size());
    }

    @Test
    void UpdateValCursTest() {
        ValCurs newValCurs = new ValCurs();
        newValCurs.setCurrency_id(valCursService.findValCursByWriteId(5L).getCurrency_id());
        newValCurs.setCurrency_numcode(valCursService.findValCursByWriteId(5L).getCurrency_numcode());
        newValCurs.setCurrency_charcode(valCursService.findValCursByWriteId(5L).getCurrency_charcode());
        newValCurs.setCurrency_nominal(valCursService.findValCursByWriteId(5L).getCurrency_nominal());
        newValCurs.setCurrency_name(valCursService.findValCursByWriteId(5L).getCurrency_name());
        newValCurs.setCurrency_value(valCursService.findValCursByWriteId(5L).getCurrency_value().replace(",", "."));
        newValCurs.setCurrency_date(valCursService.findValCursByWriteId(5L).getCurrency_date());
        valCursService.updateValCurs(1L, newValCurs);
        assertEquals("Доллар США", valCursService.findValCursByWriteId(1L).getCurrency_name());
    }

    @Test
    void getLastEntryTest() {
        assertEquals(51L, valCursService.getLastEntry().getWrite_id());
    }

    @Test
    void DataEntryForspecifiedDateTest() {
        valCursService.dataEntryForspecifiedDate(LocalDateTime.now());
        List<ValCurs> valCursList = valCursService.findValCursByDate(LocalDateTime.now());
        for (ValCurs valCurs : valCursList) {
            assertEquals(valCurs.getCurrency_date().toLocalDate(), LocalDateTime.now().toLocalDate());
        }
    }
}
