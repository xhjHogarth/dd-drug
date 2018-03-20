package com.xhj.dddrug.dto;

import java.util.List;

/**
 * User: asus
 * Date: 2018/3/17
 * Time: 21:54
 * Version:V1.0
 */
public class Result<T> {
    //符合条件的记录总数
    private Long total;
    //指定页码查询出来的记录集合
    private List<T> rows;

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    @Override
    public String toString() {
        return "Result{" +
                "total=" + total +
                ", rows=" + rows +
                '}';
    }
}
