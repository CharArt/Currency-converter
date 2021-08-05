package com.ccon.chap.dto;

import java.util.ArrayList;
import java.util.List;


public class CursDate {
    private List<CursDynamic> cursDynamicList = new ArrayList<CursDynamic>();

    public List<CursDynamic> getCursDynamicList() {
        return cursDynamicList;
    }

    public void setCursDynamicList(List<CursDynamic> cursDynamicList) {
        this.cursDynamicList = cursDynamicList;
    }
}
