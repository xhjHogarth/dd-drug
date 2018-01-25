package com.xhj.dddrug.vo;

/**
 * User: asus
 * Date: 2018/1/23
 * Time: 12:47
 * Version:V1.0
 */
public class QueryVo {
    private int pageNow;
    private int pageSize;

    public int getPageNow() {
        return pageNow;
    }

    public void setPageNow(int pageNow) {
        this.pageNow = pageNow;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public String toString() {
        return "QueryVo{" +
                "pageNow=" + pageNow +
                ", pageSize=" + pageSize +
                '}';
    }
}
