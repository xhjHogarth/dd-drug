package com.xhj.dddrug.service.impl;

import com.xhj.dddrug.dao.SearchMapper;
import com.xhj.dddrug.pojo.Drug;
import com.xhj.dddrug.pojo.Metabolite;
import com.xhj.dddrug.pojo.Protein;
import com.xhj.dddrug.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * User: asus
 * Date: 2018/4/23
 * Time: 21:55
 * Version:V1.0
 */
@Service
public class SearchServiceImpl implements SearchService{

    @Autowired
    public SearchMapper searchDao;

    @Override
    public Drug selectDrugByDrugName(Map<String, Object> map) {
        Drug drug = searchDao.selectDrugByDrugName(map);
        return drug;
    }

    @Override
    public Drug selectDrugByDrugbank(Map<String, Object> map) {
        Drug drug = searchDao.selectDrugByDrugbank(map);
        return drug;
    }

    @Override
    public Protein selectProteinByPname(Map<String, Object> map) {
        Protein protein = searchDao.selectProteinByPname(map);
        return protein;
    }

    @Override
    public Protein selectProteinByGeneSymbol(Map<String, Object> map) {
        Protein protein = searchDao.selectProteinByGeneSymbol(map);
        return protein;
    }

    @Override
    public Protein selectProteinByGeneId(Map<String, Object> map) {
        Protein protein = searchDao.selectProteinByGeneId(map);
        return protein;
    }

    @Override
    public Protein selectProteinByUpkb(Map<String, Object> map) {
        Protein protein = searchDao.selectProteinByUpkb(map);
        return protein;
    }

    @Override
    public Metabolite selectMetaboliteByMname(Map<String, Object> map) {
        Metabolite metabolite = searchDao.selectMetaboliteByMname(map);
        return metabolite;
    }

    @Override
    public Metabolite selectMetaboliteByKc(Map<String, Object> map) {
        Metabolite metabolite = searchDao.selectMetaboliteByKc(map);
        return metabolite;
    }

    @Override
    public Metabolite selectMetaboliteByHmdb(Map<String, Object> map) {
        Metabolite metabolite = searchDao.selectMetaboliteByHmdb(map);
        return metabolite;
    }
}
