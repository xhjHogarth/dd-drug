package com.xhj.dddrug.service.impl;

import com.xhj.dddrug.dao.ProteinMapper;
import com.xhj.dddrug.pojo.Protein;
import com.xhj.dddrug.service.ProteinService;
import com.xhj.dddrug.utils.PageBean;
import com.xhj.dddrug.vo.QueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public PageBean<Protein> selectProteins(QueryVo vo) {
        //得到返回的结果集
        List<Protein> proteins = new ArrayList<>();
        List<String> proteinsGeneSymbol = proteinDao.selectProteins(vo);
        int size1 = 0;
        int size2 = 0;
        size2 = proteinsGeneSymbol.size();
        while (size2>size1){
            List<String> temp = proteinDao.selectProteinsByList(proteinsGeneSymbol);
            proteinsGeneSymbol = temp;
            size1 = size2;
            size2 = proteinsGeneSymbol.size();
        }
        List<String> temp2 = proteinDao.selectProteins(vo);
        for(int j=0;j<temp2.size();j++){
            if(!proteinsGeneSymbol.contains(temp2.get(j))){
                proteinsGeneSymbol.add(temp2.get(j));
            }
        }
        Map<String,Object> proteinsAndVo = new HashMap<>();
        proteinsAndVo.put("proteinsGeneSymbol",proteinsGeneSymbol);
        proteinsAndVo.put("vo",vo);
        proteins = proteinDao.selectProteinsByPage(proteinsAndVo);
        for(int i=0;i<proteins.size();i++){
            Protein protein = proteins.get(i);
            //为了前台显示的数据的Num是连续的
            //这个pid和数据库中的pid是不同的
            protein.setPid((vo.getPageNow()-1)*5+i+1);
            proteins.set(i,protein);
        }
        PageBean<Protein> pageBean = new PageBean<>();
        pageBean.setData(proteins);
        pageBean.setPageNow(vo.getPageNow());
        pageBean.setPageSize(vo.getPageSize());
        pageBean.setSerachKey(vo.getDrugName());
        int count = proteinDao.queryProteinCount(proteinsGeneSymbol);
        int pageCount = count/5 + (count%5==0?0:1);
        pageBean.setPageCount(pageCount);
        return pageBean;
    }
}
