package com.xhj.dddrug.pojo;

/**
 * User: asus
 * Date: 2018/1/26
 * Time: 0:12
 * Version:V1.0
 */
public class Drug {
    private int did;
    private String dname;
    private String drugbank;
    private String type;

    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getDrugbank() {
        return drugbank;
    }

    public void setDrugbank(String drugbank) {
        this.drugbank = drugbank;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Drug{" +
                "did=" + did +
                ", dname='" + dname + '\'' +
                ", drugbank='" + drugbank + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
