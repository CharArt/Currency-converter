package com.ccon.chap.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

public class ValuteCursOnDate implements Serializable {

    private String name;
    private String nom;
    private String curs;
    private String code;
    private String chCode;
    private LocalDateTime date;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCurs() {
        return curs;
    }

    public void setCurs(String curs) {
        this.curs = curs;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getChCode() {
        return chCode;
    }

    public void setChCode(String chCode) {
        this.chCode = chCode;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public boolean equals(ValuteCursOnDate valuteCursOnDate) {
        return this.name.equals(valuteCursOnDate.name) &&
                this.nom.equals(valuteCursOnDate.nom) &&
                this.curs.equals(valuteCursOnDate.curs) &&
                this.code.equals(valuteCursOnDate.code) &&
                this.chCode.equals(valuteCursOnDate.chCode) &&
                this.date.equals(valuteCursOnDate.date);
    }
}
