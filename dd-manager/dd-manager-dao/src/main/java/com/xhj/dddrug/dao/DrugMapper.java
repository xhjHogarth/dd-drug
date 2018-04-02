package com.xhj.dddrug.dao;

import com.xhj.dddrug.pojo.*;
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
    public List<Protein> selectProteins(ResultDrug drug);

    public List<Metabolite> selectMetabolites(Map<String,Object> data);

    public List<Reference> selectReference(ResultDrug drug);

    public String selectDrugBank(ResultDrug drug);

    public List<String> selectProteinName(List<String> data);

    //public List<String> selectEnzymeName(List<String> data);

    public List<DrugVo> selectDrugAndProtein(ResultDrug drug);

    public List<ProteinEnzymeVo> selectProteinAndEnzyme(Map<String,Object> map);

    public List<EnzymeMetVo> selectEnzymeMet(Map<String,Object> map);

    public List<Protein> selectProteinsByList(Map<String, Object> data);

    public List<String> selectProteinsPname(List<String> data);

    public List<Enzyme> selectEnzymeByProteins(Map<String,Object> data);

    public List<String> selectEnzymeByEnzyme(List<String> enzymeNames1);

    public List<ProteinEnzymeVo> selectProteinToProtein(Map<String,Object> data);

    public List<ProteinEnzymeVo> selectEnzymeToEnzyme(List<String> enzymeNames1);

    public List<Metabolite> listMetabolites(Map<String, Object> map);

    public List<Reference> listReferences(Map<String, Object> map);
}
