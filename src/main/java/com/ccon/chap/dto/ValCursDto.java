package com.ccon.chap.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDateTime;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ValCursDto {

    private Long write_id;
    private String currency_id;
    private short currency_numcode;
    private String currency_charcode;
    private int currency_nominal;
    private String currency_name;
    private String currency_value;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime currency_date;


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
}