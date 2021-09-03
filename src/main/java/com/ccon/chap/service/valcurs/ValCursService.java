package com.ccon.chap.service.valcurs;

import com.ccon.chap.dto.ValCursDto;
import com.ccon.chap.entity.ValCurs;

import java.time.LocalDateTime;
import java.util.List;

public interface ValCursService {

    ValCurs findValCursByWriteId(Long write_id);

    ValCurs getLastEntry();

    List<ValCurs> findValCursByCurrencyId(String currencyId);

    List<ValCurs> findValCursByNumCode(Short numcode);

    List<ValCurs> findByCharCode(String charcode);

    List<ValCurs> findValCursByName(String name);

    List<ValCurs> findValCursByDate(LocalDateTime date);

    List<ValCurs> findAll();

    void createdNewValCurs(ValCurs valCurs);

    void updateValCurs(Long writeId, ValCurs newValCurs);

    void dataEntryForspecifiedDate(LocalDateTime enteringDate);

    void fillingInDatabaseValCura();

    void updateDatabaseValCura();

    //DTO
    ValCursDto findValCursDtoByWriteId(Long id);

    ValCursDto getLastEntryDto();

    List<ValCursDto> findAllDto();

    List<ValCursDto> findValCursDtoByName(String name);

    List<ValCursDto> findValCursDtoByCurrencyId(String currencyId);

    List<ValCursDto> findValCursDtoByNumCode(Short numcode);

    List<ValCursDto> findValCursDtoByDate(LocalDateTime date);

    void createdNewValCursDto(ValCursDto valCurs);

    void updateValCursDto(Long id, ValCursDto newValCursDto);

}