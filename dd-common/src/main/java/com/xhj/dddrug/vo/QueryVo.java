package com.xhj.dddrug.vo;

/**
 * User: asus
 * Date: 2018/1/23
 * Time: 12:47
 * Version:V1.0
 */
public class QueryVo {
    private int pageNow;
    private int rowNumber;//从第几行数据开始
    private int pageSize;
    private String drugName;

    public int getPageNow() {
        return pageNow;
    }

    public void setPageNow(int pageNow) {
        this.pageNow = pageNow;
    }

    public int getRowNumber() {
        return rowNumber;
    }

    public void setRowNumber(int rowNumber) {
        this.rowNumber = rowNumber;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    @Override
    public String toString() {
        return "QueryVo{" +
                "pageNow=" + pageNow +
                ", rowNumber=" + rowNumber +
                ", pageSize=" + pageSize +
                ", drugName='" + drugName + '\'' +
                '}';
    }
}
