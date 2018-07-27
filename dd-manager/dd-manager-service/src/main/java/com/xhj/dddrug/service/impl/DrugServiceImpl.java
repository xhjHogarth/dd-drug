package com.xhj.dddrug.service.impl;

import com.xhj.dddrug.dao.DrugMapper;
import com.xhj.dddrug.dto.Order;
import com.xhj.dddrug.dto.Page;
import com.xhj.dddrug.dto.Result;
import com.xhj.dddrug.pojo.*;
import com.xhj.dddrug.service.DrugService;
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
 * Date: 2018/1/26
 * Time: 0:07
 * Version:V1.0
 */
@Service
public class DrugServiceImpl implements DrugService{

    @Autowired
    public DrugMapper drugDao;

    public static String webName = "HNepTox";

    @Override
    public List<Protein> selectProteins(ResultDrug drug) {
        List<Protein> proteins = new ArrayList<>();
        //查询与药物直接相关的相关蛋白
        List<Protein> data = drugDao.selectProteins(drug);
        if(data.size()>=3){
            proteins.add(data.get(0));
            proteins.add(data.get(1));
            proteins.add(data.get(2));
        }else{
            proteins.addAll(data);
        }
        return proteins;
    }


    @Override
    public List<Metabolite> selectMetabolites(ResultDrug drug) {
        List<Metabolite> metabolites = new ArrayList<>();
        List<Protein> data1 = new ArrayList<>();
        //药物之间相关的相关蛋白
        data1 = drugDao.selectProteins(drug);
        Map<String,Object> map = new HashMap<>();//存通过药物直接查到的相关蛋白，和 type
        map.put("type",drug.getType());
        map.put("data",data1);
        //相关蛋白直接相关的酶
        List<Enzyme> enzymeNames1 = drugDao.selectEnzymeByProteins(map);//通过所有的相关蛋白查到的直接有关系的所有酶
        map.put("data",enzymeNames1);
        //酶直接相关的代谢物
        List<Metabolite> data = drugDao.selectMetabolites(map);
        if(data.size()>=3){
            metabolites.add(data.get(0));
            metabolites.add(data.get(1));
            metabolites.add(data.get(2));
        }else{
            metabolites.addAll(data);
        }
        return metabolites;
    }

    @Override
    public List<Reference> selectReference(ResultDrug drug) {
        List<Reference> references = new ArrayList<>();
        List<Reference> data = drugDao.selectReference(drug);
        if(data.size()>=3){
            references.add(data.get(0));
            references.add(data.get(1));
            references.add(data.get(2));
        }else{
            references.addAll(data);
        }
        return references;
    }

    @Override
    public String selectDrugBank(ResultDrug drug) {
        return drugDao.selectDrugBank(drug);
    }

    @Override
    public List<Node> setNodes(ResultDrug drug) {
        List<Node> nodes = new ArrayList<>();
        //查询与药物直接相关的相关蛋白
        List<Protein> data = drugDao.selectProteins(drug);
        Map<String,Object> map = new HashMap<>();//存通过药物直接查到的相关蛋白，和 type
        map.put("type",drug.getType());
        //药物节点
        Node node1 = new Node();
        Attributes attributes1 = new Attributes();
        attributes1.setX(0);
        attributes1.setY(70);
        node1.setAttributes(attributes1);
        node1.setSize(15);
        node1.setCategory(0);
        node1.setName(drug.getDrugName());
        node1.setId(drug.getDrugName());
        nodes.add(node1);
        //相关蛋白节点
        double[][] xy2 = RandomXY.getXY(data.size());
        for (int i =0;i<data.size();i++){
            Node node2 = new Node();
            Attributes attribute2 = new Attributes();
            attribute2.setX(200+xy2[i][0]);
            attribute2.setY(70+xy2[i][1]);
            node2.setAttributes(attribute2);
            node2.setSize(15);
            node2.setCategory(1);
            node2.setId(data.get(i).getGene_symbol());
            node2.setName(data.get(i).getGene_symbol());
            nodes.add(node2);
        }
        //酶节点
        map.put("data",data);
        List<Enzyme> enzymeNames1 = drugDao.selectEnzymeByProteins(map);//通过所有的相关蛋白查到的直接有关系的所有酶
        for(int i =0;i<enzymeNames1.size();i++){
            for(int j=0;j<data.size();j++){
                if(enzymeNames1.get(i).getEname().equals(data.get(j).getGene_symbol())){
                    Enzyme enzyme = enzymeNames1.get(i);
                    enzyme.setType("cf");
                    enzymeNames1.set(i,enzyme);
                }
            }
        }
        for(int i=0;i<enzymeNames1.size();i++){
            if("cf".equals(enzymeNames1.get(i).getType())){
                continue;//因为存在同一个名字的酶和相关蛋白，遇到这样的把它当作相关蛋白
                        //遇到，则跳过此次循环
            }
            Node node3 = new Node();
            Attributes attributes3 = new Attributes();
            double[][] xy3 = RandomXY.getXY(enzymeNames1.size());
            attributes3.setX(575+xy3[i][0]);
            attributes3.setY(70+xy3[i][1]);
            node3.setAttributes(attributes3);
            node3.setSize(15);
            node3.setCategory(2);
            node3.setId(enzymeNames1.get(i).getEname());
            node3.setName(enzymeNames1.get(i).getEname());
            nodes.add(node3);
        }
        //代谢物节点
        map.put("data",enzymeNames1);
        List<Metabolite> metaboliteNames = drugDao.selectMetabolites(map);
        double[][] xy4 = RandomXY.getXY(metaboliteNames.size());
        for(int i = 0;i<metaboliteNames.size();i++){
            Node node4 = new Node();
            Attributes attributes4 = new Attributes();
            attributes4.setX(950+xy4[i][0]);
            attributes4.setY(70+xy4[i][1]);
            node4.setAttributes(attributes4);
            node4.setSize(15);
            node4.setCategory(3);
            node4.setId(metaboliteNames.get(i).getMname());
            node4.setName(metaboliteNames.get(i).getMname());
            nodes.add(node4);
        }
        return nodes;
    }

    @Override
    public List<Link> setLinks(ResultDrug drug) {
        List<Link> links = new ArrayList<>();
        DrugVo drugVo = new DrugVo();
        ProteinEnzymeVo proteinEnzymeVo = new ProteinEnzymeVo();
        ProteinEnzymeVo proteinProteinVo = new ProteinEnzymeVo();
        ProteinEnzymeVo enzymeEnzymeVo = new ProteinEnzymeVo();
        EnzymeMetVo enzymeMetVo = new EnzymeMetVo();
        //查询得到药物-相关蛋白的关系
        List<DrugVo> drugVos = drugDao.selectDrugAndProtein(drug);
        for(int i=0;i<drugVos.size();i++){
            Link link = new Link();
            drugVo = drugVos.get(i);
            link.setSource(drugVo.getDname());
            link.setTarget(drugVo.getPname());
            links.add(link);
        }
        //查询得到蛋白-蛋白的关系
        List<Protein> data = drugDao.selectProteins(drug);
        Map<String,Object> map = new HashMap<>();//存通过药物直接查到的相关蛋白，和 type
        map.put("type",drug.getType());
        map.put("data",data);
        List<ProteinEnzymeVo> proteinToProtein = drugDao.selectProteinToProtein(map);
        for(int i = 0;i<proteinToProtein.size();i++){
            Link link = new Link();
            proteinProteinVo = proteinToProtein.get(i);
            link.setSource(proteinProteinVo.getPname());
            link.setTarget(proteinProteinVo.getPname_e());
            links.add(link);
        }
        //查询得到蛋白-酶的关系
        List<Enzyme> enzymeNames1 = drugDao.selectEnzymeByProteins(map);//通过所有的相关蛋白查到的直接有关系的所有酶
        List<ProteinEnzymeVo> proteinEnzymeVos = drugDao.selectProteinAndEnzyme(map);
        for(int i = 0;i<proteinEnzymeVos.size();i++){
            Link link = new Link();
            proteinEnzymeVo = proteinEnzymeVos.get(i);
            link.setSource(proteinEnzymeVo.getPname());
            link.setTarget(proteinEnzymeVo.getPname_e());
            links.add(link);
        }
        //查询得到酶-代谢物的关系
        map.put("data",enzymeNames1);
        List<EnzymeMetVo> enzymeMetVos = drugDao.selectEnzymeMet(map);
        for(int i=0;i<enzymeMetVos.size();i++){
            Link link = new Link();
            enzymeMetVo = enzymeMetVos.get(i);
            link.setSource(enzymeMetVo.getEname());
            link.setTarget(enzymeMetVo.getMname());
            links.add(link);
        }
        return links;
    }

    @Override
    public Result<Metabolite> listMetabolites(ResultDrug drug, Page page, Order order) {
        Result<Metabolite> result = new Result<>();
        String drugName = drug.getDrugName();
        String type = drug.getType();
        //查询所有的相关蛋白
        List<Protein> proteins = drugDao.selectProteins(drug);
        Map<String,Object> map = new HashMap<>();//存通过药物直接查到的相关蛋白，和 type
        map.put("type",drug.getType());
        map.put("data",proteins);
        //查询所有的酶
        List<Enzyme> enzymeNames1 = drugDao.selectEnzymeByProteins(map);//通过所有的相关蛋白查到的直接有关系的所有酶
        map.put("data",enzymeNames1);
        //查询所有的代谢物
        List<Metabolite> data = drugDao.selectMetabolites(map);
        map.put("metabolites",data);
        map.put("page",page);
        map.put("order",order);
        //查询总的记录条数
        int total = data.size();
        result.setTotal(total*1L);
        //查询指定页码的记录集合
        List<Metabolite> list = drugDao.listMetabolites(map);
        Map<String,Object> map2 = new HashMap<>();
        map2.put("drugName",drugName);
        map2.put("type",type);
        for (Metabolite metabolite:list) {
            String kc = metabolite.getKc();
            map2.put("kc",kc);
            int count = drugDao.countDrugMetabolite(map2);
            if(count>0){
                String typeStr = "";
                typeStr = drugDao.selectType(map2);
                metabolite.setDrugType(typeStr);
            }else{
                metabolite.setDrugType("Predicted");
            }
            String hmdb = metabolite.getHmdb();
            String hmdbStr = "<a href=\"http://www.hmdb.ca/metabolites/"+hmdb+"\" style=\"color: #C55A11\">"+hmdb+"</a>";
            String kcStr = "<a href=\"http://www.kegg.jp/dbget-bin/www_bget?cpd:"+kc+"\" style=\"color: #C55A11\">"+kc+"</a>";
            metabolite.setHmdb(hmdbStr);
            metabolite.setKc(kcStr);
        }
        result.setRows(list);
        return result;
    }

    @Override
    public Result<Reference> listReferences(ResultDrug drug, Page page, Order order) {
        Result<Reference> result = new Result<>();
        Map<String,Object> map = new HashMap<>();
        //查询所有符合条件的文献编号
        List<Reference> temp = drugDao.selectReference(drug);
        map.put("references",temp);
        map.put("page",page);
        map.put("order",order);
        map.put("type",drug.getType());
        List<Reference> references = drugDao.listReferences(map);
        for(int i=0;i<references.size();i++){
            String pmid = references.get(i).getPmid();
            String reStr = "<a href=\"https://www.ncbi.nlm.nih.gov/pubmed/?term="+pmid+"\" style=\"color: #C55A11\">"+pmid+"</a>";
            references.get(i).setPmid(reStr);
        }
        //总的记录条数
        int total = temp.size();
        result.setTotal(total*1L);
        //指定页码的记录集合
        result.setRows(references);
        return result;
    }

    @Override
    public Result<Link> listEdges(ResultDrug drug,Page page) {
        Result<Link> result = new Result<>();
        List<Link> links = new ArrayList<>();
        DrugVo drugVo = new DrugVo();
        ProteinEnzymeVo proteinEnzymeVo = new ProteinEnzymeVo();
        ProteinEnzymeVo proteinProteinVo = new ProteinEnzymeVo();
        ProteinEnzymeVo enzymeEnzymeVo = new ProteinEnzymeVo();
        EnzymeMetVo enzymeMetVo = new EnzymeMetVo();
        //查询得到药物-相关蛋白的关系
        List<DrugVo> drugVos = drugDao.selectDrugAndProtein(drug);
        for(int i=0;i<drugVos.size();i++){
            Link link = new Link();
            drugVo = drugVos.get(i);
            link.setSource(drugVo.getDname());
            link.setTarget(drugVo.getPname());
            links.add(link);
        }
        //查询得到蛋白-蛋白的关系
        List<Protein> data = new ArrayList<>();
        int size1 = 0;
        int size2 = 0;
        data = drugDao.selectProteins(drug);
        size2 = data.size();
        Map<String,Object> map = new HashMap<>();//存通过药物直接查到的相关蛋白，和 type
        map.put("type",drug.getType());
        while (size2>size1){
            map.put("data",data);
            List<Protein> temp = drugDao.selectProteinsByList(map);
            data = temp;
            size1 = size2;
            size2 = data.size();
        }
        List<Protein> temp2 = drugDao.selectProteins(drug);
        List<String> pname1 = new ArrayList<>();
        List<String> pname2 = new ArrayList<>();
        for(int i = 0;i<data.size();i++){
            pname1.add(data.get(i).getGene_symbol());
        }
        for(int i = 0;i<temp2.size();i++){
            pname2.add(temp2.get(i).getGene_symbol());
        }
        for(int j=0;j<temp2.size();j++){
            if(!pname1.contains(pname2.get(j))){
                data.add(temp2.get(j));
            }
        }
        map.put("data",data);
        List<ProteinEnzymeVo> proteinToProtein = drugDao.selectProteinToProtein(map);
        for(int i = 0;i<proteinToProtein.size();i++){
            Link link = new Link();
            proteinProteinVo = proteinToProtein.get(i);
            link.setSource(proteinProteinVo.getPname());
            link.setTarget(proteinProteinVo.getPname_e());
            links.add(link);
        }
        //查询得到蛋白-酶的关系
        map.put("data",data);
        List<Enzyme> enzymeNames1 = drugDao.selectEnzymeByProteins(map);//通过所有的相关蛋白查到的直接有关系的所有酶
//        Map<String,Object> proteinEnzymeMap = new HashMap<>();
//        proteinEnzymeMap.put("proteins",data);
//        proteinEnzymeMap.put("enzymes",enzymeNames1);
        List<ProteinEnzymeVo> proteinEnzymeVos = drugDao.selectProteinAndEnzyme(map);
        for(int i = 0;i<proteinEnzymeVos.size();i++){
            Link link = new Link();
            proteinEnzymeVo = proteinEnzymeVos.get(i);
            link.setSource(proteinEnzymeVo.getPname());
            link.setTarget(proteinEnzymeVo.getPname_e());
            links.add(link);
        }
        //查询得到酶-代谢物的关系
        map.put("data",enzymeNames1);
        List<EnzymeMetVo> enzymeMetVos = drugDao.selectEnzymeMet(map);
        for(int i=0;i<enzymeMetVos.size();i++){
            Link link = new Link();
            enzymeMetVo = enzymeMetVos.get(i);
            link.setSource(enzymeMetVo.getEname());
            link.setTarget(enzymeMetVo.getMname());
            links.add(link);
        }
        result.setTotal(links.size()*1L);
        List<Link> limitLinks = new ArrayList<>();
        if((page.getPage()*page.getRows()-links.size())<page.getRows() && (page.getPage()*page.getRows()-links.size())>0){
            for (int i = page.getOffset();i<links.size();i++){
                limitLinks.add(links.get(i));
            }
        }else{
            for (int i = page.getOffset();i<(page.getRows()*page.getPage());i++){
                limitLinks.add(links.get(i));
            }
        }
        result.setRows(limitLinks);
        return result;
    }

    @Override
    public Result<Drug> drugBrowse(Map<String, Object> map) {
        Result<Drug> result = new Result<>();
        List<Drug> list1 = new ArrayList<>();
        List<Drug> list2 = new ArrayList<>();
        list1 = drugDao.drugBrowseAll(map);
        list2 = drugDao.drugBrowseByPage(map);
        result.setTotal(list1.size()*1L);
        for (Drug drug:list2) {
            String drugbank = drug.getDrugbank();
            if("".equals(drugbank) || drugbank==null){
                drugbank = "No";
            }else {
                String drugbankStr = "<a href=\"https://www.drugbank.ca/drugs/"+drugbank+"\" style=\"color: #C55A11\">"+drugbank+"</a>";
                drugbank = drugbankStr;
            }
            drug.setDrugbank(drugbank);
        }
        result.setRows(list2);
        return result;
    }

    @Override
    public Result<Protein> listProteins(Map<String, Object> map) {
        ResultDrug resultDrug = new ResultDrug();
        Result<Protein> result = new Result<>();
        resultDrug.setDrugName((String) map.get("drugName"));
        resultDrug.setType((String)map.get("type"));
        List<Protein> proteins = drugDao.selectProteins(resultDrug);
        List<Protein> proteinList = drugDao.listProteinsByPage(map);
        result.setTotal(proteins.size()*1L);
        for (int i=0;i<proteinList.size();i++){
            String pname = proteinList.get(i).getPname();
            String gene_symbol = proteinList.get(i).getGene_symbol();
            String eg_id = proteinList.get(i).getEg_id();
            String upkb = proteinList.get(i).getUpkb();
            String type = proteinList.get(i).getType();
            Protein protein = new Protein();
            String geneStr = "<a href=\"/"+webName+"/proteinDetail.action?gene_symbol="+gene_symbol+"&type="+type+"\" style=\"color: #C55A11\">"+gene_symbol+"</a>";
            String egStr = "<a href=\"https://www.ncbi.nlm.nih.gov/gene/?term="+eg_id+"\" style=\"color: #C55A11\">"+eg_id+"</a>";
            String upkbStr = "<a href=\"http://www.uniprot.org/uniprot/"+upkb+"\" style=\"color: #C55A11\">"+upkb+"</a>";
            protein.setPname(pname);
            protein.setGene_symbol(geneStr);
            protein.setEg_id(egStr);
            protein.setUpkb(upkbStr);
            protein.setType(type);
            proteinList.set(i,protein);
        }
        result.setRows(proteinList);
        return result;
    }
}
