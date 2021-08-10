package com.ccon.chap.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "history")
public class History implements Serializable {

    public History(ValCurs writeOfId, ValCurs writeInId, User user, LocalDateTime date_valcurs, LocalDateTime date_conversion) {
        this.writeOfId = writeOfId;
        this.writeInId = writeInId;
        this.user = user;
        this.date_valcurs = date_valcurs;
        this.date_conversion = date_conversion;
    }

    public History() {}

    @Id
    @Column(name = "request_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long request_id;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "write_of_id", insertable = false, updatable = false)
    private ValCurs writeOfId;

    @ManyToMany
    @JoinColumn(name = "write_in_id", insertable = false, updatable = false)
    private ValCurs writeInId;

    @ManyToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private User user;

    @Column(name = "date_valcurs")
    private LocalDateTime date_valcurs;

    @Column(name = "date_conversion")
    private LocalDateTime date_conversion;

    public Long getRequest_id() {
        return request_id;
    }

    public void setRequest_id(Long request_id) {
        this.request_id = request_id;
    }

    public ValCurs getWriteOfId() {
        return writeOfId;
    }

    public void setWriteOfId(ValCurs writeOfId) {
        this.writeOfId = writeOfId;
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

    public LocalDateTime getDate_valcurs() {
        return date_valcurs;
    }

    public void setDate_valcurs(LocalDateTime date_valcurs) {
        this.date_valcurs = date_valcurs;
    }

    public LocalDateTime getDate_conversion() {
        return date_conversion;
    }

    public void setDate_conversion(LocalDateTime date_conversion) {
        this.date_conversion = date_conversion;
    }
}