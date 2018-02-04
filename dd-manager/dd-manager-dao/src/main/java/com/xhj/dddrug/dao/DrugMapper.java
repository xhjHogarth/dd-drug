package com.xhj.dddrug.dao;

import com.xhj.dddrug.vo.DrugVo;
import com.xhj.dddrug.vo.EnzymeMetVo;
import com.xhj.dddrug.vo.ProteinEnzymeVo;

import java.util.List;
import java.util.Map;

/**
 * User: asus
 * Date: 2018/1/26
 * Time: 0:07
 * Version:V1.0
 */
public interface DrugMapper {
    public List<String> selectProteins(String drugname);

    public List<String> selectMetabolites(List<String> data);

    public List<String> selectReference(String drugname);

    public String selectDrugBank(String drugName);

    public List<String> selectProteinName(List<String> data);

    //public List<String> selectEnzymeName(List<String> data);

    public List<DrugVo> selectDrugAndProtein(String drugName);

    public List<ProteinEnzymeVo> selectProteinAndEnzyme(Map<String,Object> proteinEnzymeMap);

    public List<EnzymeMetVo> selectEnzymeMet(List<String> enzymeNames1);

    public List<String> selectProteinsByList(List<String> data);

    public List<String> selectProteinsPname(List<String> data);

    public List<String> selectEnzymeByProteins(List<String> data);

    public List<String> selectEnzymeByEnzyme(List<String> enzymeNames1);

    public List<ProteinEnzymeVo> selectProteinToProtein(List<String> data);

    public List<ProteinEnzymeVo> selectEnzymeToEnzyme(List<String> enzymeNames1);
}
