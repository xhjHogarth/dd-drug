package com.xhj.dddrug.service.impl;

import com.xhj.dddrug.dao.MetaboliteMapper;
import com.xhj.dddrug.dto.Page;
import com.xhj.dddrug.dto.Result;
import com.xhj.dddrug.pojo.*;
import com.xhj.dddrug.service.MetaboliteService;
import com.xhj.dddrug.utils.Attributes;
import com.xhj.dddrug.utils.Link;
import com.xhj.dddrug.utils.Node;
import com.xhj.dddrug.utils.RandomXY;
import com.xhj.dddrug.vo.DrugVo;
import com.xhj.dddrug.vo.EnzymeMetVo;
import com.xhj.dddrug.vo.ProteinEnzymeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: asus
 * Date: 2018/4/2
 * Time: 17:46
 * Version:V1.0
 */
@Service
public class MetaboliteServiceImpl implements MetaboliteService{

    @Autowired
    public MetaboliteMapper metaboliteDao;

    public static String webName = "HNepTox";

    @Override
    public ResultMetabolite listMetabolite(Map<String, Object> map,ResultMetabolite resultMetabolite) {
        List<Drug> drugs = new ArrayList<>();
        List<Protein> proteins = new ArrayList<>();
        List<Enzyme> enzymes = new ArrayList<>();
        //查询与代谢物直接相关的所有酶
        enzymes = metaboliteDao.selectEnzyme(map);
        //查询与酶直接相关的所有的相关蛋白
        map.put("data",enzymes);
        proteins = metaboliteDao.selectProtein(map);
        List<Protein> proteinList = new ArrayList<>();
        if(proteins.size()>=3){
            proteinList.add(proteins.get(0));
            proteinList.add(proteins.get(1));
            proteinList.add(proteins.get(2));
        }else {
            proteinList.addAll(proteins);
        }
        resultMetabolite.setProteins(proteinList);
        //查询与相关蛋白直接相关的所有的药物
        map.put("data",proteins);
        drugs = metaboliteDao.selectDrug(map);
        List<Drug> drugList = new ArrayList<>();
        if(drugs.size()>=3){
            drugList.add(drugs.get(0));
            drugList.add(drugs.get(1));
            drugList.add(drugs.get(2));
        }else {
            drugList.addAll(drugs);
        }
        resultMetabolite.setDrugs(drugList);
        return resultMetabolite;
    }

    @Override
    public Result<Drug> listDrugs(Map<String, Object> map) {
        Result<Drug> result = new Result<>();
        List<Enzyme> enzymes = new ArrayList<>();
        List<Protein> proteins = new ArrayList<>();
        List<Drug> drugs = new ArrayList<>();
        List<Drug> drugList = new ArrayList<>();
        //查询与代谢物直接相关的所有的酶
        enzymes = metaboliteDao.selectEnzyme(map);
        //查询与酶直接相关的所有的蛋白质
        map.put("data",enzymes);
        proteins = metaboliteDao.selectProtein(map);
        //查询与相关蛋白直接相关的所有的药
        map.put("data",proteins);
        drugs = metaboliteDao.selectDrug(map);
        //分页查询药物
        drugList = metaboliteDao.selectDrugByPage(map);
        for(int i=0;i<drugList.size();i++){
            if("".equals(drugList.get(i).getDrugbank()) || drugList.get(i).getDrugbank()==null){

            }else {
                String drugbank = drugList.get(i).getDrugbank();
                String dname = drugList.get(i).getDname();
                String str = "<a href=\"https://www.drugbank.ca/drugs/"+drugbank+"\" style=\"color: #C55A11\">"+drugbank+"</a>";
                Drug drug = new Drug();
                drug.setDrugbank(str);
                drug.setDname(dname);
                drugList.set(i,drug);
            }
        }
        result.setTotal(drugs.size()*1L);
        result.setRows(drugList);
        return result;
    }

    @Override
    public Result<Protein> listProtein(Map<String, Object> map) {
        Result<Protein> result = new Result<>();
        List<Enzyme> enzymes = new ArrayList<>();
        List<Protein> proteins = new ArrayList<>();
        List<Protein> proteinList = new ArrayList<>();
        enzymes = metaboliteDao.selectEnzyme(map);
        map.put("data",enzymes);
        proteins = metaboliteDao.selectProtein(map);
        proteinList = metaboliteDao.selectProteinByPage(map);
        for (int i=0;i<proteinList.size();i++){
            String pname = proteinList.get(i).getPname();
            String gene_symbol = proteinList.get(i).getGene_symbol();
            String eg_id = proteinList.get(i).getEg_id();
            String upkb = proteinList.get(i).getUpkb();
            String type = proteinList.get(i).getType();
            Protein protein = new Protein();
            String egStr = "<a href=\"https://www.ncbi.nlm.nih.gov/gene/?term="+eg_id+"\" style=\"color: #C55A11\">"+eg_id+"</a>";
            String upkbStr = "<a href=\"http://www.uniprot.org/uniprot/"+upkb+"\" style=\"color: #C55A11\">"+upkb+"</a>";
            protein.setPname(pname);
            protein.setGene_symbol(gene_symbol);
            protein.setEg_id(egStr);
            protein.setUpkb(upkbStr);
            protein.setType(type);
            proteinList.set(i,protein);
        }
        result.setTotal(proteins.size()*1L);
        result.setRows(proteinList);
        return result;
    }

    @Override
    public List<Node> setNodes(Map<String, Object> map) {
        List<Node> nodes = new ArrayList<>();
        List<Drug> drugs = new ArrayList<>();
        List<Protein> proteins = new ArrayList<>();
        List<Enzyme> enzymes = new ArrayList<>();
        //RandomXY randomXY = new RandomXY();
        Metabolite metabolite = (Metabolite) map.get("data");
        //药物节点
        enzymes = metaboliteDao.selectEnzyme(map);
        map.put("data",enzymes);
        proteins = metaboliteDao.selectProtein(map);
        map.put("data",proteins);
        drugs = metaboliteDao.selectDrug(map);
        double[][] xy = RandomXY.getXY(drugs.size());
        for(int i =0;i<drugs.size();i++){
            Node node = new Node();
            Attributes attributes = new Attributes();
            attributes.setX(xy[i][0]);
            attributes.setY(70+xy[i][1]);
            node.setAttributes(attributes);
            node.setCategory(0);
            node.setSize(15);
            node.setId(drugs.get(i).getDname());
            node.setName(drugs.get(i).getDname());
            nodes.add(node);
        }
        //相关蛋白节点
        List<String> pnames = new ArrayList<>();
        double[][] xy2 = RandomXY.getXY(proteins.size());
        for(int i=0;i<proteins.size();i++){
            pnames.add(proteins.get(i).getGene_symbol());
            Attributes attributes = new Attributes();
            attributes.setX(350+xy2[i][0]);
            attributes.setY(70+xy2[i][1]);
            Node node = new Node();
            node.setAttributes(attributes);
            node.setCategory(1);
            node.setSize(15);
            node.setId(proteins.get(i).getGene_symbol());
            node.setName(proteins.get(i).getGene_symbol());
            nodes.add(node);
        }
        //酶节点
        //判断酶和相关蛋白是否重复(同名的，又是相关蛋白的，又是酶的)
        for(int i =0;i<enzymes.size();i++){
            if(pnames.contains(enzymes.get(i).getEname())){
                enzymes.get(i).setEname("cf");
            }
        }
        for(int i =0;i<enzymes.size();i++){
            if("cf".equals(enzymes.get(i).getEname())){
                continue;
            }
            Attributes attributes = new Attributes();
            double[][] xy3 = RandomXY.getXY(enzymes.size());
            attributes.setX(700+xy3[i][0]);
            attributes.setY(70+xy3[i][1]);
            Node node = new Node();
            node.setCategory(2);
            node.setAttributes(attributes);
            node.setSize(15);
            node.setId(enzymes.get(i).getEname());
            node.setName(enzymes.get(i).getEname());
            nodes.add(node);
        }
        //代谢物节点
        Node node = new Node();
        Attributes attributes = new Attributes();
        attributes.setX(900);
        attributes.setY(70);
        node.setAttributes(attributes);
        node.setCategory(3);
        node.setSize(15);
        node.setId(metabolite.getMname());
        node.setName(metabolite.getMname());
        nodes.add(node);
        return nodes;
    }

    @Override
    public List<Link> setLinks(Map<String, Object> map,Metabolite metabolite) {
        List<Link> links = new ArrayList<>();
        List<DrugVo> drugVos = new ArrayList<>();
        List<ProteinEnzymeVo> proteinEnzymeVos = new ArrayList<>();
        List<ProteinEnzymeVo> proteinProteinVos = new ArrayList<>();
        List<EnzymeMetVo> enzymeMetVos = new ArrayList<>();
        List<Drug> drugs = new ArrayList<>();
        List<Protein> proteins = new ArrayList<>();
        List<Enzyme> enzymes = new ArrayList<>();
        enzymes = metaboliteDao.selectEnzyme(map);
        map.put("data",enzymes);
        proteins = metaboliteDao.selectProtein(map);
        map.put("data",proteins);
        drugs = metaboliteDao.selectDrug(map);
        //药物-相关蛋白
        map.put("drugs",drugs);
        map.put("proteins",proteins);
        map.put("enzymes",enzymes);
        drugVos = metaboliteDao.selectDrugProtein(map);
        for(int i=0;i<drugVos.size();i++){
            Link link = new Link();
            link.setSource(drugVos.get(i).getDname());
            link.setTarget(drugVos.get(i).getPname());
            links.add(link);
        }
        //相关蛋白-相关蛋白
        proteinProteinVos = metaboliteDao.selectProteinProtein(map);
        for (int i =0;i<proteinProteinVos.size();i++){
            Link link = new Link();
            link.setSource(proteinProteinVos.get(i).getPname());
            link.setTarget(proteinProteinVos.get(i).getPname_e());
            links.add(link);
        }
        //相关蛋白-酶
        proteinEnzymeVos = metaboliteDao.selectProteinEnzyme(map);
        for (int i =0;i<proteinEnzymeVos.size();i++){
            Link link = new Link();
            link.setSource(proteinEnzymeVos.get(i).getPname());
            link.setTarget(proteinEnzymeVos.get(i).getPname_e());
            links.add(link);
        }
        //酶-代谢物
        map.put("data",metabolite);
        enzymeMetVos = metaboliteDao.selectEnzymeMetabolite(map);
        for(int i =0;i<enzymeMetVos.size();i++){
            Link link = new Link();
            link.setSource(enzymeMetVos.get(i).getEname());
            link.setTarget(enzymeMetVos.get(i).getMname());
            links.add(link);
        }
        return links;
    }

    @Override
    public Result<Link> listEdgeByPage(Map<String, Object> map,Metabolite metabolite) {
        Result<Link> result = new Result<>();
        List<Link> links = new ArrayList<>();
        List<DrugVo> drugVos = new ArrayList<>();
        List<ProteinEnzymeVo> proteinEnzymeVos = new ArrayList<>();
        List<ProteinEnzymeVo> proteinProteinVos = new ArrayList<>();
        List<EnzymeMetVo> enzymeMetVos = new ArrayList<>();
        List<Drug> drugs = new ArrayList<>();
        List<Protein> proteins = new ArrayList<>();
        List<Enzyme> enzymes = new ArrayList<>();
        enzymes = metaboliteDao.selectEnzyme(map);
        map.put("data",enzymes);
        proteins = metaboliteDao.selectProtein(map);
        map.put("data",proteins);
        drugs = metaboliteDao.selectDrug(map);
        //药物-相关蛋白
        map.put("drugs",drugs);
        map.put("proteins",proteins);
        map.put("enzymes",enzymes);
        drugVos = metaboliteDao.selectDrugProtein(map);
        for(int i=0;i<drugVos.size();i++){
            Link link = new Link();
            link.setSource(drugVos.get(i).getDname());
            link.setTarget(drugVos.get(i).getPname());
            links.add(link);
        }
        //相关蛋白-相关蛋白
        proteinProteinVos = metaboliteDao.selectProteinProtein(map);
        for (int i =0;i<proteinProteinVos.size();i++){
            Link link = new Link();
            link.setSource(proteinProteinVos.get(i).getPname());
            link.setTarget(proteinProteinVos.get(i).getPname_e());
            links.add(link);
        }
        //相关蛋白-酶
        proteinEnzymeVos = metaboliteDao.selectProteinEnzyme(map);
        for (int i =0;i<proteinEnzymeVos.size();i++){
            Link link = new Link();
            link.setSource(proteinEnzymeVos.get(i).getPname());
            link.setTarget(proteinEnzymeVos.get(i).getPname_e());
            links.add(link);
        }
        //酶-代谢物
        map.put("data",metabolite);
        enzymeMetVos = metaboliteDao.selectEnzymeMetabolite(map);
        for(int i =0;i<enzymeMetVos.size();i++){
            Link link = new Link();
            link.setSource(enzymeMetVos.get(i).getEname());
            link.setTarget(enzymeMetVos.get(i).getMname());
            links.add(link);
        }
        Page page = (Page)map.get("page");
        List<Link> linkList = new ArrayList<>();
        if((page.getPage()*page.getRows()-links.size())<page.getRows() && (page.getPage()*page.getPage()-links.size())>0){
            for(int i =page.getOffset();i<links.size();i++){
                linkList.add(links.get(i));
            }
        }else {
            for (int i = page.getOffset();i<(page.getRows()*page.getPage());i++){
                linkList.add(links.get(i));
            }
        }
        result.setTotal(links.size()*1L);
        result.setRows(linkList);
        return result;
    }

    @Override
    public Metabolite selectMetabolie(String mname, String type) {
        Metabolite metabolite = new Metabolite();
        Map<String,Object> map = new HashMap<>();
        map.put("data",mname);
        map.put("type",type);
        metabolite = metaboliteDao.selectMetabolie(map);
        return metabolite;
    }
}
