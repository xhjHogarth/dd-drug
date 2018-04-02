package com.xhj.dddrug.service.impl;

import com.xhj.dddrug.dao.DataMapper;
import com.xhj.dddrug.pojo.Drug;
import com.xhj.dddrug.pojo.Enzyme;
import com.xhj.dddrug.pojo.Metabolite;
import com.xhj.dddrug.pojo.Protein;
import com.xhj.dddrug.service.DataService;
import com.xhj.dddrug.vo.DrugRefVo;
import com.xhj.dddrug.vo.DrugVo;
import com.xhj.dddrug.vo.EnzymeMetVo;
import com.xhj.dddrug.vo.ProteinEnzymeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * User: asus
 * Date: 2018/3/25
 * Time: 22:18
 * Version:V1.0
 */
@Service
public class DataServiceImpl implements DataService{

    @Autowired
    public DataMapper dataDao;

    @Override
    public void enterDrug(Drug drug) {
        dataDao.enterDrug(drug);
    }

    @Override
    public void enterProtein(Protein protein) {
        dataDao.enterProtein(protein);
    }

    @Override
    public int existProtein(Protein protein) {
        return dataDao.existProtein(protein);
    }

    @Override
    public void enterEnzyme(Enzyme enzyme) {
        dataDao.enterEnzyme(enzyme);
    }

    @Override
    public void updateEnzyme(Enzyme enzyme) {
        dataDao.updateEnzyme(enzyme);
    }

    @Override
    public int existEnzyme(String ename) {
        return dataDao.existEnzyme(ename);
    }

    @Override
    public void enterMetabolite(Metabolite metabolite) {
        dataDao.enterMetabolite(metabolite);
    }

    @Override
    public int existMetabolite(Metabolite metabolite) {
        return dataDao.existMetabolite(metabolite);
    }

    @Override
    public String selectPname(String pid) {
        return dataDao.selectPname(pid);
    }

    @Override
    public void enterDrugProtein(DrugVo drugVo) {
        dataDao.enterDrugProtein(drugVo);
    }

    @Override
    public void enterProteinProtein(ProteinEnzymeVo proteinEnzymeVo) {
        dataDao.enterProteinProtein(proteinEnzymeVo);
    }

    @Override
    public int existProteinById(String pid1) {
        return dataDao.existProteinById(pid1);
    }

    @Override
    public String selectEname(String pid2) {
        return dataDao.selectEname(pid2);
    }

    @Override
    public int existEnzymeById(String pid1) {
        return dataDao.existEnzymeById(pid1);
    }

    @Override
    public String selectMname(String pid2) {
        return dataDao.selectMname(pid2);
    }

    @Override
    public void enterEnzymeMe(EnzymeMetVo enzymeMetVo) {
        dataDao.enterEnzymeMe(enzymeMetVo);
    }

    @Override
    public void enterDrugRef(DrugRefVo drugRefVo) {
        dataDao.enterDrugRef(drugRefVo);
    }


}
