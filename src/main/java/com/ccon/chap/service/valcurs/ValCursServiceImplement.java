package com.ccon.chap.service.valcurs;

import com.ccon.chap.dto.CursDynamic;
import com.ccon.chap.dto.ValCursDto;
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
import java.util.stream.Collectors;

@Service
@Transactional
public class ValCursServiceImplement implements ValCursService {

    private final ValCursRepository repository;
    private final ParcerService parcerService;
    private final CustomDateTimeService customDateTimeService;

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
    public ValCurs getLastEntry() {
        return repository.lastEntry();
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
    public void updateValCurs(Long writeId, ValCurs newValCurs) {
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
    public void dataEntryForspecifiedDate(LocalDateTime enteringDate) {
        try {
            List<CursDynamic> cursDynamicList = parcerService.getCursDynamicList();
            List<ValuteCursOnDate> valuteCursOnDateList = parcerService.getValuteCursOnDate(enteringDate);
            for (ValuteCursOnDate valuteCursOnDate : valuteCursOnDateList) {
                ValCurs valCurs = new ValCurs();
                valCurs.setCurrency_numcode(Short.parseShort(valuteCursOnDate.getCode()));
                valCurs.setCurrency_charcode(valuteCursOnDate.getChCode());
                valCurs.setCurrency_nominal(Integer.parseInt(valuteCursOnDate.getNom()));
                valCurs.setCurrency_name(valuteCursOnDate.getName());
                valCurs.setCurrency_value(valuteCursOnDate.getCurs().replace(",", "."));
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
    public void fillingInDatabaseValCura() {
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
                valCurs.setCurrency_value(valuteCursOnDate.getCurs().replace(",", "."));
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
    public void updateDatabaseValCura() {
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
                valCurs.setCurrency_value(valuteCursOnDate.getCurs().replace(",", "."));
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
    public ValCursDto findValCursDtoByWriteId(Long id) {
        return toDto(findValCursByWriteId(id));
    }

    @Override
    public ValCursDto getLastEntryDto() {
        return toDto(getLastEntry());
    }

    @Override
    public List<ValCursDto> findAllDto() {
        return findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public List<ValCursDto> findValCursDtoByName(String name) {
        return findValCursByName(name).stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public List<ValCursDto> findValCursDtoByCurrencyId(String currencyId) {
        return findValCursByCurrencyId(currencyId).stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public List<ValCursDto> findValCursDtoByNumCode(Short numcode) {
        return findValCursByNumCode(numcode).stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public List<ValCursDto> findValCursDtoByDate(LocalDateTime date) {
        return findValCursByDate(date).stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public void createdNewValCursDto(ValCursDto valCursDto) {
        createdNewValCurs(toValCursCreate(valCursDto));
    }

    @Override
    public void updateValCursDto(Long id, ValCursDto newValCursDto) {
        updateValCurs(id, toValCursUpdate(newValCursDto));
    }


    private ValCursDto toDto(ValCurs valCurs) {
        ValCursDto valCursDto = new ValCursDto();
        valCursDto.setWrite_id(valCurs.getWrite_id());
        valCursDto.setCurrency_id(valCurs.getCurrency_id());
        valCursDto.setCurrency_numcode(valCurs.getCurrency_numcode());
        valCursDto.setCurrency_charcode(valCurs.getCurrency_charcode());
        valCursDto.setCurrency_nominal(valCurs.getCurrency_nominal());
        valCursDto.setCurrency_name(valCurs.getCurrency_name());
        valCursDto.setCurrency_value(valCurs.getCurrency_value());
        valCursDto.setCurrency_date(valCurs.getCurrency_date());
        return valCursDto;
    }

    private ValCurs toValCursUpdate(ValCursDto valCursDto) {
        ValCurs valCurs = new ValCurs();
        valCurs.setCurrency_id(valCursDto.getCurrency_id());
        valCurs.setCurrency_numcode(valCursDto.getCurrency_numcode());
        valCurs.setCurrency_charcode(valCursDto.getCurrency_charcode());
        valCurs.setCurrency_name(valCursDto.getCurrency_name());
        valCurs.setCurrency_value(valCursDto.getCurrency_value());
        valCurs.setCurrency_nominal(valCursDto.getCurrency_nominal());
        valCurs.setCurrency_date(valCursDto.getCurrency_date());
        return valCurs;
    }

    private ValCurs toValCursCreate(ValCursDto valCursDto) {
        ValCurs valCurs = new ValCurs();
        valCurs.setCurrency_id(valCursDto.getCurrency_id());
        valCurs.setCurrency_numcode(valCursDto.getCurrency_numcode());
        valCurs.setCurrency_charcode(valCursDto.getCurrency_charcode());
        valCurs.setCurrency_name(valCursDto.getCurrency_name());
        valCurs.setCurrency_value(valCursDto.getCurrency_value());
        valCurs.setCurrency_nominal(valCursDto.getCurrency_nominal());
        valCurs.setCurrency_date(LocalDateTime.now());
        return valCurs;
    }
}
