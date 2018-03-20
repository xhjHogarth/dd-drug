package com.xhj.dddrug.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * User: asus
 * Date: 2018/3/19
 * Time: 17:19
 * Version:V1.0
 */
public class Order {
    private String sort;
    private String order;

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public List<String> getOrderParams(){
        String[] sorts = this.sort.split(",");
        String[] orders = this.order.split(",");
        List<String> list = new ArrayList<>();
        for (int i = 0;i<sorts.length;i++){
            String str = sorts[i] + " " + orders[i];
            list.add(str);
        }
        return list;  //mname asc,hmdb desc
    }
}
