package com.ccon.chap.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "history")
public class History implements Serializable {

    @Id
    @Column(name = "request_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long request_id;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "write_of_id")
    private ValCurs writOfId;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "write_in_id")
    private ValCurs writeInId;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "question")
    private float question;

    @Column(name = "answer")
    private float answer;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "date_valcurs")
    private LocalDateTime dateValcurs;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "date_conversion")
    private LocalDateTime dateConversion;

    public History() {
    }

    public History(ValCurs writOfId, ValCurs writeInId, User user, float question, float answer, LocalDateTime dateValcurs, LocalDateTime dateConversion) {
        this.writOfId = writOfId;
        this.writeInId = writeInId;
        this.user = user;
        this.question = question;
        this.answer = answer;
        this.dateValcurs = dateValcurs;
        this.dateConversion = dateConversion;
    }

    public Long getRequest_id() {
        return request_id;
    }

    public void setRequest_id(Long request_id) {
        this.request_id = request_id;
    }

    public ValCurs getWritOfId() {
        return writOfId;
    }

    public void setWritOfId(ValCurs writOfId) {
        this.writOfId = writOfId;
    }

    public ValCurs getWriteInId() {
        return writeInId;
    }

    public void setWriteInId(ValCurs writeInId) {
        this.writeInId = writeInId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public float getQuestion() {
        return question;
    }

    public void setQuestion(float question) {
        this.question = question;
    }

    public float getAnswer() {
        return answer;
    }

    public void setAnswer(float answer) {
        this.answer = answer;
    }

    public LocalDateTime getDateValcurs() {
        return dateValcurs;
    }

    public void setDateValcurs(LocalDateTime dateValcurs) {
        this.dateValcurs = dateValcurs;
    }

    public LocalDateTime getDateConversion() {
        return dateConversion;
    }

    public void setDateConversion(LocalDateTime dateConversion) {
        this.dateConversion = dateConversion;
    }
}