package com.xhj.dddrug.service.impl;

import com.xhj.dddrug.dao.ProteinMapper;
import com.xhj.dddrug.dto.Page;
import com.xhj.dddrug.dto.Result;
import com.xhj.dddrug.pojo.Drug;
import com.xhj.dddrug.pojo.Enzyme;
import com.xhj.dddrug.pojo.Metabolite;
import com.xhj.dddrug.pojo.Protein;
import com.xhj.dddrug.service.ProteinService;
import com.xhj.dddrug.utils.*;
import com.xhj.dddrug.vo.DrugVo;
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
public class ProteinServiceImpl implements ProteinService{

    @Autowired
    public ProteinMapper proteinDao;

    public static String webName = "HNepTox";

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
    public List<Drug> selectDrugs(Map<String, Object> map) {
        List<Drug> drugs = proteinDao.selectDrugs(map);
        List<Drug> drugs1 = new ArrayList<>();
        if(drugs.size()>=3){
            drugs1.add(drugs.get(0));
            drugs1.add(drugs.get(1));
            drugs1.add(drugs.get(2));
        }else{
            drugs1.addAll(drugs);
        }
        return drugs1;
    }

    @Override
    public List<Metabolite> selectMetabolites(Map<String, Object> map) {
        List<Enzyme> enzymes = proteinDao.selectEnzyme(map);
        map.put("data",enzymes);
        List<Metabolite> metabolites = proteinDao.selectMetabolites(map);
        List<Metabolite> metabolites1 = new ArrayList<>();
        if(metabolites.size()>=3){
            metabolites1.add(metabolites.get(0));
            metabolites1.add(metabolites.get(1));
            metabolites1.add(metabolites.get(2));
        }else{
            metabolites1.addAll(metabolites);
        }
        return metabolites1;
    }

    @Override
    public Result<Drug> selectDrugsByPage(Map<String, Object> map) {
        Result<Drug> result = new Result<>();
        List<Drug> drugs = proteinDao.selectDrugs(map);
        List<Drug> drugList = proteinDao.listDrugs(map);
        for(int i = 0;i<drugList.size();i++){
            String drugbank = drugList.get(i).getDrugbank();
            String dname = drugList.get(i).getDname();
            String str = "<a href=\"https://www.drugbank.ca/drugs/"+drugbank+"\" style=\"color: #C55A11\">"+drugbank+"</a>";
            Drug drug = new Drug();
            drug.setDrugbank(str);
            drug.setDname(dname);
            drugList.set(i,drug);
        }
        result.setTotal(drugs.size()*1L);
        result.setRows(drugList);
        return result;
    }

    @Override
    public List<Node> setNodes(Map<String, Object> map) {
        List<Node> nodes = new ArrayList<>();
        Protein protein = (Protein) map.get("data");
        //药物节点
        List<Drug> drugs = proteinDao.selectDrugs(map);
        double[][] xy1 = RandomXY.getXY(drugs.size());
        for (int i=0;i<drugs.size();i++) {
            Node node1 = new Node();
            Attributes attributes = new Attributes();
            attributes.setX(xy1[i][0]);
            attributes.setY(70+xy1[i][1]);
            node1.setAttributes(attributes);
            node1.setSize(15);
            node1.setCategory(0);
            node1.setName(drugs.get(i).getDname());
            node1.setId(drugs.get(i).getDname());
            nodes.add(node1);
        }
        //相关蛋白节点
        Node node2 = new Node();
        Attributes attributes = new Attributes();
        attributes.setX(250);
        attributes.setY(70);
        node2.setAttributes(attributes);
        node2.setSize(15);
        node2.setCategory(1);
        node2.setName(protein.getGene_symbol());
        node2.setId(protein.getGene_symbol());
        nodes.add(node2);
        //酶节点
        List<Enzyme> enzymes = proteinDao.selectEnzyme(map);
        double[][] xy3 = RandomXY.getXY(enzymes.size());
        for (int i = 0;i<enzymes.size();i++){
            if(protein.getGene_symbol().equals(enzymes.get(i).getEname())){
                enzymes.get(i).setEname("cf");
            }
        }
        for(int i = 0;i<enzymes.size();i++){
            if("cf".equals(enzymes.get(i).getEname())){
                continue;
            }
            Node node3 = new Node();
            Attributes attributes1 = new Attributes();
            attributes1.setX(500+xy3[i][0]);
            attributes1.setY(70+xy3[i][1]);
            node3.setAttributes(attributes1);
            node3.setSize(15);
            node3.setCategory(2);
            node3.setName(enzymes.get(i).getEname());
            node3.setId(enzymes.get(i).getEname());
            nodes.add(node3);
        }
        //代谢物节点
        map.put("data",enzymes);
        List<Metabolite> metabolites = proteinDao.selectMetabolites(map);
        double[][] xy4 = RandomXY.getXY(metabolites.size());
        for (int i = 0;i<metabolites.size();i++){
            Node node4 = new Node();
            Attributes attributes1 = new Attributes();
            attributes1.setX(900+xy4[i][0]);
            attributes1.setY(70+xy4[i][1]);
            node4.setAttributes(attributes1);
            node4.setSize(15);
            node4.setCategory(3);
            node4.setName(metabolites.get(i).getMname());
            node4.setId(metabolites.get(i).getMname());
            nodes.add(node4);
        }
        return nodes;
    }

    @Override
    public List<Link> setLinks(Map<String, Object> map) {
        List<Link> links = new ArrayList<>();
        DrugVo drugVo = new DrugVo();
        ProteinEnzymeVo proteinEnzymeVo = new ProteinEnzymeVo();
        EnzymeMetVo enzymeMetVo = new EnzymeMetVo();
        //Protein protein = (Protein) map.get("data");
        //药物-相关蛋白
        List<DrugVo> drugVos = proteinDao.selectDrugProtein(map);
        for(int i =0;i<drugVos.size();i++){
            Link link = new Link();
            drugVo = drugVos.get(i);
            link.setSource(drugVo.getPname());
            link.setTarget(drugVo.getDname());
            links.add(link);
        }
        //相关蛋白-酶
        List<ProteinEnzymeVo> proteinEnzymeVos = proteinDao.selectProteinEnzyme(map);
        for(int i =0;i<proteinEnzymeVos.size();i++){
            Link link = new Link();
            proteinEnzymeVo = proteinEnzymeVos.get(i);
            link.setSource(proteinEnzymeVo.getPname());
            link.setTarget(proteinEnzymeVo.getPname_e());
            links.add(link);
        }
        //酶-代谢物
        List<Enzyme> enzymes = proteinDao.selectEnzyme(map);
        map.put("data",enzymes);
        List<EnzymeMetVo> enzymeMetVos = proteinDao.selectEnzymeMetabolite(map);
        for (int i = 0;i<enzymeMetVos.size();i++){
            Link link = new Link();
            enzymeMetVo = enzymeMetVos.get(i);
            link.setSource(enzymeMetVo.getEname());
            link.setTarget(enzymeMetVo.getMname());
            links.add(link);
        }
        return links;
    }

    @Override
    public Result<Metabolite> selectMetabolitesByPage(Map<String, Object> map) {
        Result<Metabolite> result = new Result<>();
        List<Enzyme> enzymes = proteinDao.selectEnzyme(map);
        map.put("data",enzymes);
        List<Metabolite> metabolites = proteinDao.selectMetabolites(map);
        List<Metabolite> metaboliteList = proteinDao.selectMetabolitesByPage(map);
        for (int i =0;i<metaboliteList.size();i++){
            String mname = metaboliteList.get(i).getMname();
            String hmdb = metaboliteList.get(i).getHmdb();
            String kc = metaboliteList.get(i).getKc();
            String type = metaboliteList.get(i).getType();
            String hmdbStr = "<a href=\"http://www.hmdb.ca/metabolites/"+hmdb+"\" style=\"color: #C55A11\">"+hmdb+"</a>";
            String kcStr = "<a href=\"http://www.kegg.jp/dbget-bin/www_bget?cpd:"+kc+"\" style=\"color: #C55A11\">"+kc+"</a>";
            Metabolite metabolite = new Metabolite();
            metabolite.setType(type);
            metabolite.setMname(mname);
            metabolite.setHmdb(hmdbStr);
            metabolite.setKc(kcStr);
            metaboliteList.set(i,metabolite);
        }
        result.setTotal(metabolites.size()*1L);
        result.setRows(metaboliteList);
        return result;
    }

    @Override
    public Result<Link> listEdges(Map<String, Object> map) {
        Result<Link> result = new Result<>();
        List<Link> links = new ArrayList<>();
        DrugVo drugVo = new DrugVo();
        ProteinEnzymeVo proteinEnzymeVo = new ProteinEnzymeVo();
        EnzymeMetVo enzymeMetVo = new EnzymeMetVo();
        //药物-相关蛋白
        List<DrugVo> drugVos = proteinDao.selectDrugProtein(map);
        for(int i =0;i<drugVos.size();i++){
            Link link = new Link();
            drugVo = drugVos.get(i);
            link.setSource(drugVo.getPname());
            link.setTarget(drugVo.getDname());
            links.add(link);
        }
        //相关蛋白-酶
        List<ProteinEnzymeVo> proteinEnzymeVos = proteinDao.selectProteinEnzyme(map);
        for(int i =0;i<proteinEnzymeVos.size();i++){
            Link link = new Link();
            proteinEnzymeVo = proteinEnzymeVos.get(i);
            link.setSource(proteinEnzymeVo.getPname());
            link.setTarget(proteinEnzymeVo.getPname_e());
            links.add(link);
        }
        //酶-代谢物
        List<Enzyme> enzymes = proteinDao.selectEnzyme(map);
        map.put("data",enzymes);
        List<EnzymeMetVo> enzymeMetVos = proteinDao.selectEnzymeMetabolite(map);
        for (int i = 0;i<enzymeMetVos.size();i++){
            Link link = new Link();
            enzymeMetVo = enzymeMetVos.get(i);
            link.setSource(enzymeMetVo.getEname());
            link.setTarget(enzymeMetVo.getMname());
            links.add(link);
        }
        Page page = (Page) map.get("page");
        List<Link> linkList = new ArrayList<>();
        if((page.getPage()*page.getRows()-links.size())<page.getRows() && (page.getPage()*page.getRows()-links.size())>0){
            for(int i =page.getOffset();i<links.size();i++){
                linkList.add(links.get(i));
            }
        }else{
            for (int i = page.getOffset();i<(page.getRows()*page.getPage());i++){
                linkList.add(links.get(i));
            }
        }
        result.setTotal(links.size()*1L);
        result.setRows(linkList);
        return result;
    }

    @Override
    public Protein selectProtein(String type, String gene_symbol) {
        Protein protein= new Protein();
        Map<String,Object> map = new HashMap<>();
        map.put("gene_symbol",gene_symbol);
        map.put("type",type);
        protein = proteinDao.selectProtein(map);
        return protein;
    }
}
