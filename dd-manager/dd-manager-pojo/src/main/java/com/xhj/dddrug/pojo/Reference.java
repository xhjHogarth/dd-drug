package com.xhj.dddrug.pojo;

/**
 * User: asus
 * Date: 2018/1/26
 * Time: 0:53
 * Version:V1.0
 */
public class Reference {

    private int rid;
    private String pmid;

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public String getPmid() {
        return pmid;
    }

    public void setPmid(String pmid) {
        this.pmid = pmid;
    }

    @Override
    public String toString() {
        return "Reference{" +
                "rid=" + rid +
                ", pmid='" + pmid + '\'' +
                '}';
    }
}
