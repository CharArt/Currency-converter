package com.ccon.chap.dto.view;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class HistoryView {

    private String userName;
    private String currencyOfName;
    private String currencyOfValue;
    private String currencyInValue;
    private String currencyInName;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date_valcurs;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date_conversion;

    public HistoryView() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCurrencyOfName() {
        return currencyOfName;
    }

    public void setCurrencyOfName(String currencyOfName) {
        this.currencyOfName = currencyOfName;
    }

    public String getCurrencyOfValue() {
        return currencyOfValue;
    }

    public void setCurrencyOfValue(String currencyOfValue) {
        this.currencyOfValue = currencyOfValue;
    }

    public String getCurrencyInValue() {
        return currencyInValue;
    }

    public void setCurrencyInValue(String currencyInValue) {
        this.currencyInValue = currencyInValue;
    }

    public String getCurrencyInName() {
        return currencyInName;
    }

    public void setCurrencyInName(String currencyInName) {
        this.currencyInName = currencyInName;
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
