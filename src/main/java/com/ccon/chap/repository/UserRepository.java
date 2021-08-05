package com.ccon.chap.repository;

import com.ccon.chap.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "SELECT * FROM \"user\" AS u WHERE u.user_login=?;", nativeQuery = true)
    User findByUserLogin(String userLogin);

    @Query(value = "SELECT * FROM \"user\" AS u WHERE u.user_email=?;", nativeQuery = true)
    User findByUserEmail(String userEmail);

    @Query(value = "SELECT * FROM \"user\" AS u WHERE u.user_of_birth=?;", nativeQuery = true)
    List<User> findByUserOfBirth(LocalDateTime userOfBirth);

    @Query(value = "SELECT * FROM \"user\" AS u WHERE u.user_is_active=?;", nativeQuery = true)
    List<User> findByUserActive(boolean userActive);

    @Query(value = "SELECT * FROM \"user\" AS u WHERE u.user_created_at=?;", nativeQuery = true)
    List<User> findByUserCreatedAt(LocalDateTime userCreatedAt);

    @Modifying
    @Query(value = "DELETE FROM \"user\" WHERE user_login=?;", nativeQuery = true)
    void deleteUserByLogin(String userLogin);

    @Modifying
    @Query(value = "DELETE FROM \"user\" WHERE user_id=?;", nativeQuery = true)
    void deleteUserById(Long user_id);
}
