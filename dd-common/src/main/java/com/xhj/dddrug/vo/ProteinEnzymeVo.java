package com.xhj.dddrug.vo;

/**
 * User: asus
 * Date: 2018/1/31
 * Time: 18:44
 * Version:V1.0
 */
public class ProteinEnzymeVo {
    private String pname;
    private String pname_e;

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPname_e() {
        return pname_e;
    }

    public void setPname_e(String pname_e) {
        this.pname_e = pname_e;
    }

    @Override
    public String toString() {
        return "ProteinEnzymeVo{" +
                "pname='" + pname + '\'' +
                ", pname_e='" + pname_e + '\'' +
                '}';
    }
}
