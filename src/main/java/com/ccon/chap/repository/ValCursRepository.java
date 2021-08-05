package com.ccon.chap.repository;

import com.ccon.chap.entity.ValCurs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface ValCursRepository extends JpaRepository<ValCurs, Long> {

    @Query(value = "SELECT * FROM valcurs AS v WHERE v.currency_id=?;", nativeQuery = true)
    List<ValCurs> findValCursByCurrencyId(String currencyId);

    @Query(value = "SELECT * FROM valcurs AS v WHERE v.currency_numcode=?;", nativeQuery = true)
    List<ValCurs> findValCursByNumCode(Short numcode);

    @Query(value = "SELECT * FROM valcurs AS v WHERE v.currency_charcode=?;", nativeQuery = true)
    List<ValCurs> findByCharCode(String charcode);

    @Query(value = "SELECT * FROM valcurs AS v WHERE v.currency_name=?;", nativeQuery = true)
    List<ValCurs> findValCursByName(String name);

    @Query(value = "SELECT * FROM valcurs AS v WHERE v.currency_date=?;", nativeQuery = true)
    List<ValCurs> findValCursByDate(LocalDateTime date);

    @Modifying
    @Query(value = "UPDATE  valcurs SET currency_id=:id, currency_numcode=:numcode, currency_charcode=:charcode, currency_nominal=:nominal, currency_name=:name, currency_value=:value, currency_date=:date WHERE write_id=:writeId", nativeQuery = true)
    void UpdateValCurs(@Param("writeId") Long writeId,
                       @Param("id") String currency_id,
                       @Param("numcode") short currency_numcode,
                       @Param("charcode") String currency_charcode,
                       @Param("nominal") int currency_nominal,
                       @Param("name") String currency_name,
                       @Param("value") String currency_value,
                       @Param("date") LocalDateTime currency_date);

    @Query(value = "SELECT * FROM valcurs ORDER BY write_id DESC LIMIT 1;", nativeQuery = true)
    ValCurs lastEntry();
}
