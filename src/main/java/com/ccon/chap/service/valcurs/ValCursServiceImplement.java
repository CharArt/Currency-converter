package com.ccon.chap.service.valcurs;

import com.ccon.chap.dto.CursDynamic;
import com.ccon.chap.dto.ValuteCursOnDate;
import com.ccon.chap.entity.ValCurs;
import com.ccon.chap.repository.ValCursRepository;
import com.ccon.chap.service.datetime.CustomDateTimeService;
import com.ccon.chap.service.parcer.ParcerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.xml.datatype.DatatypeConfigurationException;
import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class ValCursServiceImplement implements ValCursService {

    private ValCursRepository repository;
    private ParcerService parcerService;
    private CustomDateTimeService customDateTimeService;

    @Autowired
    public ValCursServiceImplement(ValCursRepository repository, ParcerService parcerService, CustomDateTimeService customDateTimeService) {
        this.repository = repository;
        this.parcerService = parcerService;
        this.customDateTimeService = customDateTimeService;
    }

    @Override
    public ValCurs findValCursByWriteId(Long write_id) {
        return repository.getOne(write_id);
    }

    @Override
    public List<ValCurs> findValCursByCurrencyId(String currencyId) {
        return repository.findValCursByCurrencyId(currencyId);
    }

    @Override
    public List<ValCurs> findValCursByNumCode(Short numcode) {
        return repository.findValCursByNumCode(numcode);
    }

    @Override
    public List<ValCurs> findByCharCode(String charcode) {
        return repository.findByCharCode(charcode);
    }

    @Override
    public List<ValCurs> findValCursByName(String name) {
        return repository.findValCursByName(name);
    }

    @Override
    public List<ValCurs> findValCursByDate(LocalDateTime date) {
        return repository.findValCursByDate(date);
    }

    @Override
    public List<ValCurs> findAll() {
        return repository.findAll();
    }

    @Override
    public void createdNewValCurs(ValCurs valCurs) {
        repository.save(valCurs);
    }

    @Override
    public void UpdateValCurs(Long writeId, ValCurs newValCurs) {
        repository.UpdateValCurs(writeId,
                newValCurs.getCurrency_id(),
                newValCurs.getCurrency_numcode(),
                newValCurs.getCurrency_charcode(),
                newValCurs.getCurrency_nominal(),
                newValCurs.getCurrency_name(),
                newValCurs.getCurrency_value(),
                newValCurs.getCurrency_date());
    }

    @Override
    public void FillingInDatabaseValCura() {
        try {
            List<LocalDateTime> listLoscalDateTime = customDateTimeService.getListOfDates(LocalDateTime.of(1993, 1, 6, 0, 0));
            List<CursDynamic> cursDynamicList = parcerService.getCursDynamicList();
            List<ValuteCursOnDate> valuteCursOnDateList = parcerService.getValuteCursOnDateList(listLoscalDateTime);
            for (ValuteCursOnDate valuteCursOnDate : valuteCursOnDateList) {
                ValCurs valCurs = new ValCurs();
                valCurs.setCurrency_numcode(Short.parseShort(valuteCursOnDate.getCode()));
                valCurs.setCurrency_charcode(valuteCursOnDate.getChCode());
                valCurs.setCurrency_nominal(Integer.parseInt(valuteCursOnDate.getNom()));
                valCurs.setCurrency_name(valuteCursOnDate.getName());
                valCurs.setCurrency_value(valuteCursOnDate.getCurs());
                valCurs.setCurrency_date(valuteCursOnDate.getDate());
                for (CursDynamic cursDynamic : cursDynamicList) {
                    if (valCurs.getCurrency_numcode() == Short.parseShort(cursDynamic.getvNumCode())) {
                        valCurs.setCurrency_id(cursDynamic.getvCode());
                    }
                }
                repository.save(valCurs);
            }
        } catch (DatatypeConfigurationException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void UpdateDatabaseValCura() {
        try {
            List<LocalDateTime> listLoscalDateTime = customDateTimeService.getListOfDatesFromLastDate();
            List<CursDynamic> cursDynamicList = parcerService.getCursDynamicList();
            List<ValuteCursOnDate> valuteCursOnDateList = parcerService.getValuteCursOnDateList(listLoscalDateTime);
            for (ValuteCursOnDate valuteCursOnDate : valuteCursOnDateList) {
                ValCurs valCurs = new ValCurs();
                valCurs.setCurrency_numcode(Short.parseShort(valuteCursOnDate.getCode()));
                valCurs.setCurrency_charcode(valuteCursOnDate.getChCode());
                valCurs.setCurrency_nominal(Integer.parseInt(valuteCursOnDate.getNom()));
                valCurs.setCurrency_name(valuteCursOnDate.getName());
                valCurs.setCurrency_value(valuteCursOnDate.getCurs());
                valCurs.setCurrency_date(valuteCursOnDate.getDate());
                for (CursDynamic cursDynamic : cursDynamicList) {
                    if (valCurs.getCurrency_numcode() == Short.parseShort(cursDynamic.getvNumCode())) {
                        valCurs.setCurrency_id(cursDynamic.getvCode());
                    }
                }
                repository.save(valCurs);
            }
        } catch (DatatypeConfigurationException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public ValCurs getLastEntry() {
        return repository.lastEntry();
    }
}
