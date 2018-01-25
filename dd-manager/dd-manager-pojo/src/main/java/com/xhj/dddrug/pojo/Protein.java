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
    private String gene_symbol;
    private String upkb;
    private String eg_id;
    private String typename;

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getGene_symbol() {
        return gene_symbol;
    }

    public void setGene_symbol(String gene_symbol) {
        this.gene_symbol = gene_symbol;
    }

    public String getUpkb() {
        return upkb;
    }

    public void setUpkb(String upkb) {
        this.upkb = upkb;
    }

    public String getEg_id() {
        return eg_id;
    }

    public void setEg_id(String eg_id) {
        this.eg_id = eg_id;
    }

    public String getType() {
        return typename;
    }

    public void setType(String typename) {
        this.typename = typename;
    }

    @Override
    public String toString() {
        return "Protein{" +
                "pid=" + pid +
                ", pname='" + pname + '\'' +
                ", gene_symbol='" + gene_symbol + '\'' +
                ", upkb='" + upkb + '\'' +
                ", eg_id='" + eg_id + '\'' +
                ", typename='" + typename + '\'' +
                '}';
    }
}
