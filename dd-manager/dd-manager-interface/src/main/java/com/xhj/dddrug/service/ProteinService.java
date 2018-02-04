package com.xhj.dddrug.service;

import com.xhj.dddrug.pojo.Protein;
import com.xhj.dddrug.utils.PageBean;
import com.xhj.dddrug.vo.QueryVo;

/**
 * User: asus
 * Date: 2018/1/19
 * Time: 21:01
 * Version:V1.0
 */
public interface ProteinService {

    public PageBean<Protein> selectProteins(QueryVo vo);
}
