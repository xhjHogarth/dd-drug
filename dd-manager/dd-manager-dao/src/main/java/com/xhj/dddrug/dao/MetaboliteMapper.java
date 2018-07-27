package com.xhj.dddrug.dao;

import com.xhj.dddrug.pojo.Drug;
import com.xhj.dddrug.pojo.Enzyme;
import com.xhj.dddrug.pojo.Metabolite;
import com.xhj.dddrug.pojo.Protein;
import com.xhj.dddrug.vo.DrugVo;
import com.xhj.dddrug.vo.EnzymeMetVo;
import com.xhj.dddrug.vo.ProteinEnzymeVo;

import java.util.List;
import java.util.Map; /**
 * User: asus
 * Date: 2018/4/2
 * Time: 17:47
 * Version:V1.0
 */
public interface MetaboliteMapper {
    public List<Enzyme> selectEnzyme(Map<String, Object> map);

    public List<Protein> selectProtein(Map<String, Object> map);

    public List<Drug> selectDrug(Map<String, Object> map);

    public List<Drug> selectDrugByPage(Map<String, Object> map);

    public List<Protein> selectProteinByPage(Map<String, Object> map);

    public List<DrugVo> selectDrugProtein(Map<String, Object> map);

    public List<ProteinEnzymeVo> selectProteinProtein(Map<String, Object> map);

    public List<ProteinEnzymeVo> selectProteinEnzyme(Map<String, Object> map);

    public List<EnzymeMetVo> selectEnzymeMetabolite(Map<String, Object> map);

    public Metabolite selectMetabolie(Map<String, Object> map);
}
