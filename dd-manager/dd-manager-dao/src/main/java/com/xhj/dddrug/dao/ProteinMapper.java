package com.xhj.dddrug.dao;

import com.xhj.dddrug.pojo.Protein;
import com.xhj.dddrug.vo.QueryVo;

import java.util.List;
import java.util.Map;

/**
 * User: asus
 * Date: 2018/1/19
 * Time: 20:58
 * Version:V1.0
 */
public interface ProteinMapper {
    //分页查询数据
    public List<String> selectProteins(QueryVo vo);

    List<String> selectProteinsByList(List<String> proteinsGeneSymbol);

    List<Protein> selectProteinsByPage(Map<String,Object> proteinsAndVo);
    //总共有多少条数据
    public int queryProteinCount(List<String> data);

}
