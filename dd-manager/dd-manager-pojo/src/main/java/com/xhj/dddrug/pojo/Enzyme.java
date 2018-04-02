package com.xhj.dddrug.pojo;

/**
 * User: asus
 * Date: 2018/1/26
 * Time: 0:20
 * Version:V1.0
 */
public class Enzyme {

    private int eid;
    private String name;
    private String ename;
    private String entrz_gene;
    private String type;

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getEntrz_gene() {
        return entrz_gene;
    }

    public void setEntrz_gene(String entrz_gene) {
        this.entrz_gene = entrz_gene;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Enzyme{" +
                "eid=" + eid +
                ", name='" + name + '\'' +
                ", ename='" + ename + '\'' +
                ", entrz_gene='" + entrz_gene + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
