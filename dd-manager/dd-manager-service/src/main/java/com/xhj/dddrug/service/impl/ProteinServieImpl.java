package com.xhj.dddrug.service.impl;

import com.xhj.dddrug.dao.ProteinMapper;
import com.xhj.dddrug.dto.Page;
import com.xhj.dddrug.dto.Result;
import com.xhj.dddrug.pojo.Metabolite;
import com.xhj.dddrug.pojo.Protein;
import com.xhj.dddrug.service.DrugService;
import com.xhj.dddrug.service.ProteinService;
import com.xhj.dddrug.utils.PageBean;
import com.xhj.dddrug.vo.EnzymeMetVo;
import com.xhj.dddrug.vo.ProteinEnzymeVo;
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
            protein.setPid((vo.getPageNow()-1)*10+i+1);
            proteins.set(i,protein);
        }
        PageBean<Protein> pageBean = new PageBean<>();
        pageBean.setData(proteins);
        pageBean.setPageNow(vo.getPageNow());
        pageBean.setPageSize(vo.getPageSize());
        pageBean.setSerachKey(vo.getDrugName());
        int count = proteinDao.queryProteinCount(proteinsGeneSymbol);
        pageBean.setDataCount(count);
        int pageCount = count/10 + (count%10==0?0:1);
        pageBean.setPageCount(pageCount);
        return pageBean;
    }

    @Override
    public int existsProtein(ProteinEnzymeVo proteinEnzymeVo) {
        int exists = proteinDao.existsProtein(proteinEnzymeVo);
        return exists;
    }

    @Override
    public int existsProtein2(ProteinEnzymeVo proteinEnzymeVo) {
        int exists = proteinDao.existsProtein2(proteinEnzymeVo);
        return exists;
    }

    @Override
    public void enterData(ProteinEnzymeVo proteinEnzymeVo) {
        proteinDao.enterData(proteinEnzymeVo);
    }

    @Override
    public int existsEnzymeMet(EnzymeMetVo enzymeMetVo) {
        int exists = proteinDao.existsEnzymeMet(enzymeMetVo);
        return exists;
    }

    @Override
    public void enterEnzymeMet(EnzymeMetVo enzymeMetVo) {
        proteinDao.enterEnzymeMet(enzymeMetVo);
    }

    @Override
    public int existProtein(String protein) {
        int exists = proteinDao.existProtein(protein);
        return exists;
    }

    @Override
    public void enterProtein(String protein) {
        proteinDao.enterProtein(protein);
    }

    @Override
    public int existsEnzyme(String enzyme) {
        int exists = proteinDao.existsEnzyme(enzyme);
        return exists;
    }

    @Override
    public void enterEnzyme(String enzyme) {
        proteinDao.enterEnzyme(enzyme);
    }

    @Override
    public int existsMetabolites(String metabolites) {
        int exists = proteinDao.existsMetabolites(metabolites);
        return exists;
    }

    @Override
    public void enterMetabolites(String metabolites) {
        proteinDao.enterMetabolites(metabolites);
    }



}
