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
    private String typename;

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

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    @Override
    public String toString() {
        return "Metabolite{" +
                "mid=" + mid +
                ", mname='" + mname + '\'' +
                ", hmdb='" + hmdb + '\'' +
                ", kc='" + kc + '\'' +
                ", typename='" + typename + '\'' +
                '}';
    }
}
