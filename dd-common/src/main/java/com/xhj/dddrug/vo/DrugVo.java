package com.xhj.dddrug.vo;

/**
 * User: asus
 * Date: 2018/1/31
 * Time: 18:31
 * Version:V1.0
 */
public class DrugVo {
    private String dname;
    private String pname;

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    @Override
    public String toString() {
        return "DrugVo{" +
                "dname='" + dname + '\'' +
                ", pname='" + pname + '\'' +
                '}';
    }
}
