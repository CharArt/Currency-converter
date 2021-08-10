package com.ccon.chap.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "valcurs")
public class ValCurs implements Serializable {

    public ValCurs() {
    }

    public ValCurs(String currency_id,
                   short currency_numcode,
                   String currency_charcode,
                   int currency_nominal,
                   String currency_name,
                   String currency_value,
                   LocalDateTime currency_date) {
        this.currency_id = currency_id;
        this.currency_numcode = currency_numcode;
        this.currency_charcode = currency_charcode;
        this.currency_nominal = currency_nominal;
        this.currency_name = currency_name;
        this.currency_value = currency_value;
        this.currency_date = currency_date;
    }

    @Id
    @Column(name = "write_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long write_id;

    @Column(name = "currency_id")
    private String currency_id;

    @Column(name = "currency_numcode")
    private short currency_numcode;

    @Column(name = "currency_charcode")
    private String currency_charcode;

    @Column(name = "currency_nominal")
    private int currency_nominal;

    @Column(name = "currency_name")
    private String currency_name;

    @Column(name = "currency_value")
    private String currency_value;

    @Column(name = "currency_date")
    private LocalDateTime currency_date;

    @ManyToMany
    @JoinColumn(name = "write_id")
    private List<History> currentHistory;

    public Long getWrite_id() {
        return write_id;
    }

    public void setWrite_id(Long write_id) {
        this.write_id = write_id;
    }

    public String getCurrency_id() {
        return currency_id;
    }

    public void setCurrency_id(String currency_id) {
        this.currency_id = currency_id;
    }

    public short getCurrency_numcode() {
        return currency_numcode;
    }

    public void setCurrency_numcode(short currency_numcode) {
        this.currency_numcode = currency_numcode;
    }

    public String getCurrency_charcode() {
        return currency_charcode;
    }

    public void setCurrency_charcode(String currency_charcode) {
        this.currency_charcode = currency_charcode;
    }

    public int getCurrency_nominal() {
        return currency_nominal;
    }

    public void setCurrency_nominal(int currency_nominal) {
        this.currency_nominal = currency_nominal;
    }

    public String getCurrency_name() {
        return currency_name;
    }

    public void setCurrency_name(String currency_name) {
        this.currency_name = currency_name;
    }

    public String getCurrency_value() {
        return currency_value;
    }

    public void setCurrency_value(String currency_value) {
        this.currency_value = currency_value;
    }

    public LocalDateTime getCurrency_date() {
        return currency_date;
    }

    public void setCurrency_date(LocalDateTime currency_date) {
        this.currency_date = currency_date;
    }

    public List<History> getCurrentHistory() {
        return currentHistory;
    }

    public void setCurrentHistory(List<History> currentHistory) {
        this.currentHistory = currentHistory;
    }


}