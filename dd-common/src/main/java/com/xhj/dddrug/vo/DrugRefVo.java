package com.xhj.dddrug.vo;

/**
 * User: asus
 * Date: 2018/3/29
 * Time: 0:51
 * Version:V1.0
 */
public class DrugRefVo {
    private String dname;
    private String pmid;
    private String type;

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getPmid() {
        return pmid;
    }

    public void setPmid(String pmid) {
        this.pmid = pmid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "DrugRefVo{" +
                "dname='" + dname + '\'' +
                ", pmid='" + pmid + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
