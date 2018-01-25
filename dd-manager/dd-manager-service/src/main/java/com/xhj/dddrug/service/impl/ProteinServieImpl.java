package com.xhj.dddrug.service.impl;

import com.xhj.dddrug.dao.ProteinMapper;
import com.xhj.dddrug.pojo.Protein;
import com.xhj.dddrug.service.ProteinService;
import com.xhj.dddrug.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * User: asus
 * Date: 2018/1/19
 * Time: 21:01
 * Version:V1.0
 */
@Service
public class ProteinServieImpl implements ProteinService{

    @Autowired
    public ProteinMapper proteinDao;

    @Override
    public PageBean<Protein> selectProteins(int pageNow) {
        //得到返回的结果集
        List<Protein> proteins = proteinDao.selectProteins((pageNow-1)*5);
        PageBean<Protein> pageBean = new PageBean<>();
        pageBean.setData(proteins);
        pageBean.setPageNow(pageNow);
        pageBean.setPageSize(5);
        int count = proteinDao.queryProteinCount();
        int pageCount = count/5 + (count%5==0?0:1);
        pageBean.setPageCount(pageCount);
        return pageBean;
    }
}
