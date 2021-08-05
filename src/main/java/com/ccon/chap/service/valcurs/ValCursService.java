package com.ccon.chap.service.valcurs;

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

    void UpdateValCurs(Long writeId, ValCurs newValCurs);

    void FillingInDatabaseValCura ();

    void UpdateDatabaseValCura ();

}
