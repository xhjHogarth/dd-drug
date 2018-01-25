package com.xhj.dddrug.dao;

import com.xhj.dddrug.pojo.Protein;

import java.util.List;

/**
 * User: asus
 * Date: 2018/1/19
 * Time: 20:58
 * Version:V1.0
 */
public interface ProteinMapper {
    //分页查询数据
    public List<Protein> selectProteins(int pageNow);

    //总共有多少条数据
    public int queryProteinCount();
}
