package com.ccon.chap.repository;

import com.ccon.chap.entity.History;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface HistoryRepository extends JpaRepository<History, Long> {

    @Query(value = "SELECT * FROM history AS h LEFT JOIN valcurs AS v ON h.write_of_id=v.write_id LEFT JOIN \"user\" AS u  ON h.user_id=u.user_id WHERE write_of_id=?;", nativeQuery = true)
    List<History> findHistoryByWriteOfId(Long writeOfId);

    @Query(value = "SELECT * FROM history AS h LEFT JOIN valcurs AS v ON h.write_in_id=v.write_id LEFT JOIN \"user\" AS u  ON h.user_id=u.user_id WHERE write_in_id=?;", nativeQuery = true)
    List<History> findHistoryByWriteInId(Long writeInId);

    @Query(value = "SELECT * FROM history AS h LEFT JOIN valcurs AS v ON h.write_in_id=v.write_id LEFT JOIN \"user\" AS u  ON h.user_id=u.user_id WHERE h.user_id=?;", nativeQuery = true)
    List<History> findHistoryByUserId(Long userId);

    @Query(value = "SELECT * FROM history WHERE date_conversion=?;", nativeQuery = true)
    List<History> findHistoryByDateConversion(LocalDateTime dateConversion);

    @Modifying
    @Query(value = "DELETE FROM history h WHERE h.request_id=:request_id",nativeQuery = true)
    void deleteHistoryById(@Param("request_id") Long request_id);

}
