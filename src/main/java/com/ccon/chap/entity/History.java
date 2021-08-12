package com.ccon.chap.entity;

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

    @Column(name = "date_valcurs")
    private LocalDateTime dateValcurs;

    @Column(name = "date_conversion")
    private LocalDateTime dateConversion;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "write_of_id")
    private ValCurs writOfId;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "write_in_id")
    private ValCurs writeInId;

    @ManyToOne(cascade =  CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    public History() {
    }

    public History(LocalDateTime dateValcurs, LocalDateTime dateConversion, ValCurs writOfId, ValCurs writeInId, User user) {
        this.dateValcurs = dateValcurs;
        this.dateConversion = dateConversion;
        this.writOfId = writOfId;
        this.writeInId = writeInId;
        this.user = user;
    }

    public Long getRequest_id() {
        return request_id;
    }

    public void setRequest_id(Long request_id) {
        this.request_id = request_id;
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
}