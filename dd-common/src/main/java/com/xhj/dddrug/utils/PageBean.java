package com.xhj.dddrug.utils;

import java.util.List;

/**
 * User: asus
 * Date: 2018/1/19
 * Time: 20:21
 * Version:V1.0
 */
public class PageBean<T> {
    private int id;
    private int pageNow;//当前的页码
    private int pageSize;//每页多少条数据
    private int pageCount;//一共有多少页
    private int dataCount;//总共有多少条数据
    private List<T> data;//这一页的具体数据

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getDataCount() {
        return dataCount;
    }

    public void setDataCount(int dataCount) {
        this.dataCount = dataCount;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "PageBean{" +
                "pageNow=" + pageNow +
                ", pageSize=" + pageSize +
                ", pageCount=" + pageCount +
                ", dataCount=" + dataCount +
                ", data=" + data +
                '}';
    }
}
