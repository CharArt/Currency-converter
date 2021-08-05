package com.ccon.chap.dto;

import java.util.ArrayList;
import java.util.List;

public class ValuteDate {

    private List<ValuteCursOnDate> rows = new ArrayList<ValuteCursOnDate>();

    public List<ValuteCursOnDate> getRows() {
        return rows;
    }

    public void setRows(List<ValuteCursOnDate> rows) {
        this.rows = rows;
    }
}