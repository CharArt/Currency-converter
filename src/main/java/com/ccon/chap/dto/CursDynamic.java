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

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        CursDynamic o = (CursDynamic) obj;
        return this.vCode.equals(o.getvCode()) &&
                this.vName.equals(o.getvName()) &&
                this.vEngName.equals(o.getvEngName()) &&
                this.vNom.equals(o.getvCommonCode()) &&
                this.vNumCode.equals(o.getvNumCode()) &&
                this.vCharCode.equals(o.getvCharCode());
    }

    public static boolean equalsCursDynamicWithoutNull(CursDynamic cursDynamic) {
        return  !cursDynamic.getvCode().equals("Null") &&
                !cursDynamic.getvName().equals("Null") &&
                !cursDynamic.getvEngName().equals("Null") &&
                !cursDynamic.getvNom().equals("Null") &&
                !cursDynamic.getvNumCode().equals("Null") &&
                !cursDynamic.getvCharCode().equals("Null");
    }

}
