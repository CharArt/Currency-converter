package com.ccon.chap.dto.view;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class ValCursView implements Serializable {

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date timeSearch;

    private String nameValuteOne;
    private String valueValuteOne;
    private String nameValuteTwo;
    private String valueValuteTwo;

    public Date getTimeSearch() {
        return timeSearch;
    }

    public void setTimeSearch(Date timeSearch) {
        this.timeSearch = timeSearch;
    }

    public String getNameValuteOne() {
        return nameValuteOne;
    }

    public void setNameValuteOne(String nameValuteOne) {
        this.nameValuteOne = nameValuteOne;
    }

    public String getValueValuteOne() {
        return valueValuteOne;
    }

    public void setValueValuteOne(String valueValuteOne) {
        this.valueValuteOne = valueValuteOne;
    }

    public String getNameValuteTwo() {
        return nameValuteTwo;
    }

    public void setNameValuteTwo(String nameValuteTwo) {
        this.nameValuteTwo = nameValuteTwo;
    }

    public String getValueValuteTwo() {
        return valueValuteTwo;
    }

    public void setValueValuteTwo(String valueValuteTwo) {
        this.valueValuteTwo = valueValuteTwo;
    }

    @Override
    public String toString() {
        return nameValuteOne + " " +
                valueValuteOne + " " +
                nameValuteTwo + " " +
                valueValuteTwo;
    }
}
