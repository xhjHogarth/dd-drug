package com.xhj.dddrug.vo;

/**
 * User: asus
 * Date: 2018/1/31
 * Time: 18:50
 * Version:V1.0
 */
public class EnzymeMetVo {
    private String ename;
    private String mname;

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    @Override
    public String toString() {
        return "EnzymeMetVo{" +
                "ename='" + ename + '\'' +
                ", mname='" + mname + '\'' +
                '}';
    }
}
