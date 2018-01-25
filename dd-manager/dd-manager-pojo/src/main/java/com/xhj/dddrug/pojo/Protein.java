package com.xhj.dddrug.pojo;

/**
 * User: asus
 * Date: 2018/1/19
 * Time: 20:54
 * Version:V1.0
 */
public class Protein {
    private int pid;
    private String pname;
    private String gname;
    private String ac_number;
    private String eg_id;


    public int getId() {
        return pid;
    }

    public void setId(int pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    public String getAc_number() {
        return ac_number;
    }

    public void setAc_number(String ac_number) {
        this.ac_number = ac_number;
    }

    public String getEg_id() {
        return eg_id;
    }

    public void setEg_id(String eg_id) {
        this.eg_id = eg_id;
    }

    @Override
    public String toString() {
        return "Protein{" +
                "pid=" + pid +
                ", pname='" + pname + '\'' +
                ", gname='" + gname + '\'' +
                ", ac_number='" + ac_number + '\'' +
                ", eg_id='" + eg_id + '\'' +
                '}';
    }
}
