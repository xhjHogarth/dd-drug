package com.xhj.dddrug.service.impl;

import com.xhj.dddrug.dao.DataMapper;
import com.xhj.dddrug.dao.DrugMapper;
import com.xhj.dddrug.pojo.*;
import com.xhj.dddrug.service.DataService;
import com.xhj.dddrug.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    @Autowired
    public DrugMapper drugDao;

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

    @Override
    public void enterDrugMet(DrugMetVo drugMetVo) {
        dataDao.enterDrugMet(drugMetVo);
    }

    @Override
    public List<Drug> selectDrugs(Map<String, Object> map) {
//        List<Drug> drugs = new ArrayList<>();
//        drugs.addAll(dataDao.selectDrugs(map));
//        drugs.addAll(dataDao.selectDrugsFromDrugAndMet(map));
        return dataDao.selectDrugs(map);
    }

    @Override
    public List<DrugMetVo> selectDrugMetVo(Drug drug) {
        List<DrugMetVo> drugMetVo = new ArrayList<>();

        List<Protein> data1 = new ArrayList<>();
        //药物之间相关的相关蛋白
        ResultDrug resultDrug = new ResultDrug();
        resultDrug.setType(drug.getType());
        resultDrug.setDrugName(drug.getDname());
        resultDrug.setDrugBank(drug.getDrugbank());
        data1 = drugDao.selectProteins(resultDrug);
        Map<String,Object> map = new HashMap<>();//存通过药物直接查到的相关蛋白，和 type
        map.put("type",drug.getType());
        map.put("data",data1);
        try {
            //相关蛋白直接相关的酶
            List<Enzyme> enzymeNames1 = drugDao.selectEnzymeByProteins(map);//通过所有的相关蛋白查到的直接有关系的所有酶
            map.put("data",enzymeNames1);
            //酶直接相关的代谢物
            List<Metabolite> data = drugDao.selectMetabolites(map);
            for(int i =0;i<data.size();i++){
                DrugMetVo drugMetVo1 = new DrugMetVo();
                drugMetVo1.setDname(drug.getDname());
                drugMetVo1.setKc(data.get(i).getKc());
                drugMetVo1.setDrugType(drug.getType());
                drugMetVo1.setType("Predicted");
                drugMetVo.add(drugMetVo1);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return drugMetVo;
    }


}
