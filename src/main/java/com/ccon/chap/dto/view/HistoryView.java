package com.ccon.chap.dto.view;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class HistoryView {
    private Long request_id;
    private String userName;
    private String currencyNameFrom;
    private String currencyValueFrom;
    private String currencyValueTo;
    private String currencyNameTo;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date_valcurs;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date_conversion;

    public Long getRequest_id() {
        return request_id;
    }

    public void setRequest_id(Long request_id) {
        this.request_id = request_id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCurrencyNameFrom() {
        return currencyNameFrom;
    }

    public void setCurrencyNameFrom(String currencyNameFrom) {
        this.currencyNameFrom = currencyNameFrom;
    }

    public String getCurrencyValueFrom() {
        return currencyValueFrom;
    }

    public void setCurrencyValueFrom(String currencyValueFrom) {
        this.currencyValueFrom = currencyValueFrom;
    }

    public String getCurrencyValueTo() {
        return currencyValueTo;
    }

    public void setCurrencyValueTo(String currencyValueTo) {
        this.currencyValueTo = currencyValueTo;
    }

    public String getCurrencyNameTo() {
        return currencyNameTo;
    }

    public void setCurrencyNameTo(String currencyNameTo) {
        this.currencyNameTo = currencyNameTo;
    }

    public Date getDate_valcurs() {
        return date_valcurs;
    }

    public void setDate_valcurs(Date date_valcurs) {
        this.date_valcurs = date_valcurs;
    }

    public Date getDate_conversion() {
        return date_conversion;
    }

    public void setDate_conversion(Date date_conversion) {
        this.date_conversion = date_conversion;
    }
}
