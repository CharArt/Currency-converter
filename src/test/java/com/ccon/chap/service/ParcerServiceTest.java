package com.ccon.chap.service;

import com.ccon.chap.configurations.JpaConfiguration;
import com.ccon.chap.dto.CursDynamic;
import com.ccon.chap.dto.ValuteCursOnDate;
import com.ccon.chap.service.parcer.ParcerService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.xml.datatype.DatatypeConfigurationException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SqlGroup({@Sql("/sql/cleaning-data-base.sql"), @Sql("/sql/create-all-table.sql")})
@Sql(scripts = "/sql/cleaning-data-base.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
@ContextConfiguration(classes = JpaConfiguration.class)
@WebAppConfiguration
public class ParcerServiceTest {

    private ParcerService parcerService;

    @Autowired
    public ParcerServiceTest(ParcerService parcerService) {
        this.parcerService = parcerService;
    }

    @Test
    void getCursDynamicListTestSize() {
        List<CursDynamic> cursDynamicList = parcerService.getCursDynamicList();
        assertEquals(61, cursDynamicList.size());
    }

    @Test
    void getCursDynamicListTestUniqu() {
        List<CursDynamic> cursDynamicList = parcerService.getCursDynamicList();
        for (int i = 1; i < cursDynamicList.size(); i++) {
            assertFalse(cursDynamicList.get(i).equals(cursDynamicList.get(i - 1)));
        }
    }

    @Test
    void getValuteCursOnDateListTest() throws DatatypeConfigurationException {
        LocalDateTime dateTime = LocalDateTime.now();
        List<LocalDateTime> localDateTimes = new ArrayList<>();
        localDateTimes.add(0, dateTime);
        List<ValuteCursOnDate> valuteCursOnDateList = parcerService.getValuteCursOnDateList(localDateTimes);
        assertEquals(34, valuteCursOnDateList.size());
    }

    @Test
    void getValuteCursOnDateListTestUniquWithoutNull() throws DatatypeConfigurationException {
        LocalDateTime dateTime = LocalDateTime.now();
        List<LocalDateTime> localDateTimes = new ArrayList<>();
        localDateTimes.add(0, dateTime);
        List<ValuteCursOnDate> valuteCursOnDateList = parcerService.getValuteCursOnDateList(localDateTimes);
        for (ValuteCursOnDate valuteCursOnDate : valuteCursOnDateList) {
            assertFalse(parcerService.equalsValuteCursOnDateWithoutNull(valuteCursOnDate));
        }
    }

    @Test
    void getValuteCursOnDateListTestUniqu() throws DatatypeConfigurationException {
        LocalDateTime dateTime = LocalDateTime.now();
        List<LocalDateTime> localDateTimes = new ArrayList<>();
        localDateTimes.add(0, dateTime);
        List<ValuteCursOnDate> valuteCursOnDateList = parcerService.getValuteCursOnDateList(localDateTimes);
        for (int i = 1; i < valuteCursOnDateList.size(); i++) {
            assertFalse(valuteCursOnDateList.get(i).equals(valuteCursOnDateList.get(i - 1)));
        }
    }

    @Test
    void getValuteCursOnDateTest () throws DatatypeConfigurationException {
        List<ValuteCursOnDate> valuteCursOnDateList = parcerService.getValuteCursOnDate(LocalDateTime.now());
        for (int i = 1; i < valuteCursOnDateList.size(); i++) {
            assertEquals(valuteCursOnDateList.get(i).getDate().toLocalDate(), LocalDateTime.now().toLocalDate());
        }
    }
}
