package com.xhj.dddrug.pojo;

/**
 * User: asus
 * Date: 2018/1/26
 * Time: 0:48
 * Version:V1.0
 */
public class Metabolite {

    private int mid;
    private String mname;
    private String hmdb;
    private String kc;
    private String type;

    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public String getHmdb() {
        return hmdb;
    }

    public void setHmdb(String hmdb) {
        this.hmdb = hmdb;
    }

    public String getKc() {
        return kc;
    }

    public void setKc(String kc) {
        this.kc = kc;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Metabolite{" +
                "mid=" + mid +
                ", mname='" + mname + '\'' +
                ", hmdb='" + hmdb + '\'' +
                ", kc='" + kc + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
