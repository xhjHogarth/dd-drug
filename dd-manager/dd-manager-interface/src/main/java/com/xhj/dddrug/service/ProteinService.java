package com.xhj.dddrug.service;

import com.xhj.dddrug.pojo.Protein;
import com.xhj.dddrug.utils.PageBean;
import com.xhj.dddrug.vo.EnzymeMetVo;
import com.xhj.dddrug.vo.ProteinEnzymeVo;
import com.xhj.dddrug.vo.QueryVo;

/**
 * User: asus
 * Date: 2018/1/19
 * Time: 21:01
 * Version:V1.0
 */
public interface ProteinService {

    public PageBean<Protein> selectProteins(QueryVo vo);

    public int existsProtein(ProteinEnzymeVo proteinEnzymeVo);

    public int existsProtein2(ProteinEnzymeVo proteinEnzymeVo);

    public void enterData(ProteinEnzymeVo proteinEnzymeVo);

    public int existsEnzymeMet(EnzymeMetVo enzymeMetVo);

    public void enterEnzymeMet(EnzymeMetVo enzymeMetVo);

    public int existProtein(String protein);

    public void enterProtein(String protein);

    public int existsEnzyme(String enzyme);

    public void enterEnzyme(String enzyme);

    public int existsMetabolites(String metabolites);

    public void enterMetabolites(String metabolites);

}
