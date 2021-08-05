package com.ccon.chap.service.parcer;

import com.ccon.chap.dto.CursDynamic;
import com.ccon.chap.dto.ValuteCursOnDate;

import javax.xml.datatype.DatatypeConfigurationException;
import java.time.LocalDateTime;
import java.util.List;

public interface ParcerService {

    List<CursDynamic> getCursDynamicList();

    List<ValuteCursOnDate> getValuteCursOnDateList(List<LocalDateTime> listDate) throws DatatypeConfigurationException;

    boolean equalsCursDynamicWithoutNull(CursDynamic cursDynamic) throws DatatypeConfigurationException;

    boolean equalsValuteCursOnDateWithoutNull (ValuteCursOnDate valuteCursOnDate)throws DatatypeConfigurationException;
}
