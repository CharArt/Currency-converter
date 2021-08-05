package com.ccon.chap.service.user;

import com.ccon.chap.entity.User;
import com.ccon.chap.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class UserServiceImplement implements UserService {

    private UserRepository repository;

    @Autowired
    public UserServiceImplement(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User findByUserId(Long userId) {
        return repository.getOne(userId);
    }

    @Override
    public User findByUserLogin(String userLogin) {
        return repository.findByUserLogin(userLogin);
    }

    @Override
    public User findByUserEmail(String userEmail) {
        return repository.findByUserEmail(userEmail);
    }

    @Override
    public List<User> findByUserOfBirth(LocalDateTime userOfBirth) {
        return repository.findByUserOfBirth(userOfBirth);
    }

    @Override
    public List<User> findByUserActive(boolean userActive) {
        return repository.findByUserActive(userActive);
    }

    @Override
    public List<User> findByUserCreatedAt(LocalDateTime userCreatedAt) {
        return repository.findByUserCreatedAt(userCreatedAt);
    }

    @Override
    public List<User> findAll() {
        return repository.findAll();
    }

    @Override
    public void createdNewUser(User newUser) {
        repository.save(newUser);
    }

    @Override
    public void deleteUserById(Long userId) {
        repository.deleteUserById(userId);
    }

    @Override
    public void deleteUserByLogin(String userLogin) {
        repository.deleteUserByLogin(userLogin);
    }

    @Override
    public boolean isPresentLogin(String userLogin) {
        User user = repository.findByUserLogin(userLogin);
        if (userLogin.equals(user.getUser_login())) return true;
        return false;
    }

    @Override
    public boolean isPresentEmail(String userEmail) {
        User user = repository.findByUserEmail(userEmail);
        if (userEmail.equals(user.getUser_email())) return true;
        return false;
    }

}
