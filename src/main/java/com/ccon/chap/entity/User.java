package com.ccon.chap.entity;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "\"user\"")
@Validated
public class User implements Serializable {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;

    @NotNull
    @Max(50)
    @Column(name = "user_login")
    private String user_login;

    @NotNull
    @Max(50)
    @Column(name = "user_name")
    private String user_name;

    @NotNull
    @Max(50)
    @Column(name = "user_surname")
    private String user_surname;

    @NotNull
    @Max(50)
    @Column(name = "user_patronymic")
    private String user_patronymic;

    @NotNull
    @Max(100)
    @Email
    @Column(name = "user_email")
    private String user_email;

    @NotNull
    @Max(100)
    @Column(name = "user_password")
    private String user_password;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "user_of_birth")
    private LocalDate user_of_birth;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    @NotNull
    @Column(name = "user_created_at")
    private LocalDateTime user_created_at;

    @Column(name = "user_is_active")
    private boolean user_is_active;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "role_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<Role> role;

    @OneToMany()
    private List<History> history;

    public User() {
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getUser_login() {
        return user_login;
    }

    public void setUser_login(String user_login) {
        this.user_login = user_login;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_surname() {
        return user_surname;
    }

    public void setUser_surname(String user_surname) {
        this.user_surname = user_surname;
    }

    public String getUser_patronymic() {
        return user_patronymic;
    }

    public void setUser_patronymic(String user_patronymic) {
        this.user_patronymic = user_patronymic;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public LocalDate getUser_of_birth() {
        return user_of_birth;
    }

    public void setUser_of_birth(LocalDate user_of_birth) {
        this.user_of_birth = user_of_birth;
    }


    public LocalDateTime getUser_created_at() {
        return user_created_at;
    }

    public void setUser_created_at(LocalDateTime user_created_at) {
        this.user_created_at = user_created_at;
    }

    public boolean isUser_is_active() {
        return user_is_active;
    }

    public void setUser_is_active(boolean user_is_active) {
        this.user_is_active = user_is_active;
    }

    public List<Role> getRole() {
        return role;
    }

    public void setRole(List<Role> role) {
        this.role = role;
    }

    public List<History> getHistory() {
        return history;
    }

    public void setHistory(List<History> history) {
        this.history = history;
    }
}