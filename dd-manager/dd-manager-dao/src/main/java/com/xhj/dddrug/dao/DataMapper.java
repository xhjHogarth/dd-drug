package com.xhj.dddrug.dao;

import com.xhj.dddrug.pojo.Drug;
import com.xhj.dddrug.pojo.Enzyme;
import com.xhj.dddrug.pojo.Metabolite;
import com.xhj.dddrug.pojo.Protein;
import com.xhj.dddrug.vo.*;

import java.util.List;
import java.util.Map;

/**
 * User: asus
 * Date: 2018/3/25
 * Time: 22:44
 * Version:V1.0
 */
public interface DataMapper {
    public void enterDrug(Drug drug);

    public void enterProtein(Protein protein);

    public int existProtein(Protein protein);

    public void enterEnzyme(Enzyme enzyme);

    public void updateEnzyme(Enzyme enzyme);

    public int existEnzyme(String ename);

    public void enterMetabolite(Metabolite metabolite);

    public int existMetabolite(Metabolite metabolite);

    public String selectPname(String pid);

    public void enterDrugProtein(DrugVo drugVo);

    public void enterProteinProtein(ProteinEnzymeVo proteinEnzymeVo);

    public int existProteinById(String pid1);

    public String selectEname(String pid2);

    public int existEnzymeById(String pid1);

    public String selectMname(String pid2);

    public void enterEnzymeMe(EnzymeMetVo enzymeMetVo);

    public void enterDrugRef(DrugRefVo drugRefVo);

    public void enterDrugMet(DrugMetVo drugMetVo);

    public List<Drug> selectDrugs(Map<String, Object> map);

    public List<Drug> selectDrugsFromDrugAndMet(Map<String, Object> map);
}
