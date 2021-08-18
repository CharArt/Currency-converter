package com.ccon.chap.service.user;

import com.ccon.chap.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.time.LocalDateTime;
import java.util.List;

public interface UserService extends UserDetailsService {

    User findByUserId(Long userId);

    User findByUserLogin(String userLogin);

    User findByUserEmail(String userEmail);

    List<User> findByUserOfBirth(LocalDateTime userOfBirth);

    List<User> findByUserActive(boolean userActive);

    List<User> findByUserCreatedAt(LocalDateTime userCreatedAt);

    List<User> findAll();

    void createdNewUser(User newUser);

    void deleteUserById(Long userId);

    void deleteUserByLogin(String userLogin);

    boolean isPresentLogin(String userLogin);

    boolean isPresentEmail(String userEmail);
}
