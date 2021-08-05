package com.ccon.chap.dto;

import java.io.Serializable;

public class CursDynamic implements Serializable {
    private String vCode;
    private String vName;
    private String vEngName;
    private String vNom;
    private String vCommonCode;
    private String vNumCode;
    private String vCharCode;

    public String getvCode() {
        return vCode;
    }

    public void setvCode(String vCode) {
        this.vCode = vCode;
    }

    public String getvName() {
        return vName;
    }

    public void setvName(String vName) {
        this.vName = vName;
    }

    public String getvEngName() {
        return vEngName;
    }

    public void setvEngName(String vEngName) {
        this.vEngName = vEngName;
    }

    public String getvNom() {
        return vNom;
    }

    public void setvNom(String vNom) {
        this.vNom = vNom;
    }

    public String getvCommonCode() {
        return vCommonCode;
    }

    public void setvCommonCode(String vCommonCode) {
        this.vCommonCode = vCommonCode;
    }

    public String getvNumCode() {
        return vNumCode;
    }

    public void setvNumCode(String vNumCode) {
        this.vNumCode = vNumCode;
    }

    public String getvCharCode() {
        return vCharCode;
    }

    public void setvCharCode(String vCharCode) {
        this.vCharCode = vCharCode;
    }

    public boolean equals(CursDynamic cursDynamic) {
        return this.vCode.equals(cursDynamic.getvCode()) &&
                this.vName.equals(cursDynamic.getvName()) &&
                this.vEngName.equals(cursDynamic.getvEngName()) &&
                this.vNom.equals(cursDynamic.getvCommonCode()) &&
                this.vNumCode.equals(cursDynamic.getvNumCode()) &&
                this.vCharCode.equals(cursDynamic.getvCharCode());
    }
}
