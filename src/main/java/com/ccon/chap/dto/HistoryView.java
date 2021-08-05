package com.ccon.chap.dto;

import java.time.LocalDateTime;

public class HistoryView {
    private Long request_id;
    private String userName;
    private String currencyNameFrom;
    private String currencyValueFrom;
    private String currencyValueTo;
    private String currencyNameTo;
    private LocalDateTime date_valcurs;
    private LocalDateTime date_conversion;

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
