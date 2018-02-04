package com.xhj.dddrug.service.impl;

import com.xhj.dddrug.dao.DrugMapper;
import com.xhj.dddrug.service.DrugService;
import com.xhj.dddrug.utils.Link;
import com.xhj.dddrug.utils.Node;
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


    @Override
    public List<String> selectProteins(String drugname) {
        List<String> proteins = new ArrayList<>();
        List<String> data = new ArrayList<>();
        int size1 = 0;
        int size2 = 0;
        data = drugDao.selectProteins(drugname);
        size2 = data.size();
        while (size2>size1){
            List<String> temp = drugDao.selectProteinsByList(data);
            data = temp;
            size1 = size2;
            size2 = data.size();
        }
        List<String> temp2 = drugDao.selectProteins(drugname);
        for(int j=0;j<temp2.size();j++){
            if(!data.contains(temp2.get(j))){
                data.add(temp2.get(j));
            }
        }
//        System.out.println("---------------------");
//        System.out.println(data.toString());
//        System.out.println("---------------------");
        data = drugDao.selectProteinsPname(data);
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
    public List<String> selectMetabolites(String drugName) {
        List<String> metabolites = new ArrayList<>();
        List<String> data1 = new ArrayList<>();
        int size1 = 0;
        int size2 = 0;
        data1 = drugDao.selectProteins(drugName);
        size2 = data1.size();
        while (size2>size1){
            List<String> temp = drugDao.selectProteinsByList(data1);
            data1 = temp;
            size1 = size2;
            size2 = data1.size();
        }
        List<String> temp2 = drugDao.selectProteins(drugName);
        for(int j=0;j<temp2.size();j++){
            if(!data1.contains(temp2.get(j))){
                data1.add(temp2.get(j));
            }
        }
        List<String> enzymeNames1 = drugDao.selectEnzymeByProteins(data1);//通过所有的相关蛋白查到的直接有关系的所有酶
        int enzymeSize1 = 0;
        int enzymeSize2 = 0;
        enzymeSize2 = enzymeNames1.size();
        while(enzymeSize2>enzymeSize1){
            List<String> enzymeTemp1 = drugDao.selectEnzymeByEnzyme(enzymeNames1);
            enzymeNames1 = enzymeTemp1;
            enzymeSize1 = enzymeSize2;
            enzymeSize2 = enzymeNames1.size();
        }
        //经过while循环查找得到的酶是酶-酶对应关系的所有酶
        //通过下面的循环把通过相关蛋白-酶的对应关系找到的酶添加进来
        List<String> enzymeTemp2 = drugDao.selectEnzymeByProteins(data1);
        for(int i=0;i<enzymeTemp2.size();i++){
            if(!enzymeNames1.contains(enzymeTemp2.get(i))){
                enzymeNames1.add(enzymeTemp2.get(i));
            }
        }
        List<String> data = drugDao.selectMetabolites(enzymeNames1);
//        System.out.println("-------------------");
//        System.out.println(data.toString());
//        System.out.println("-------------------");
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
    public List<String> selectReference(String drugName) {
        List<String> references = new ArrayList<>();
        List<String> data = drugDao.selectReference(drugName);
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
    public String selectDrugBank(String drugName) {
        return drugDao.selectDrugBank(drugName);
    }

    @Override
    public List<Node> setNodes(String drugName) {
        List<Node> nodes = new ArrayList<>();
        List<String> data = new ArrayList<>();
        int size1 = 0;
        int size2 = 0;
        data = drugDao.selectProteins(drugName);
        size2 = data.size();
        while (size2>size1){
            List<String> temp = drugDao.selectProteinsByList(data);
            data = temp;
            size1 = size2;
            size2 = data.size();
        }
        List<String> temp2 = drugDao.selectProteins(drugName);
        for(int j=0;j<temp2.size();j++){
            if(!data.contains(temp2.get(j))){
                data.add(temp2.get(j));
            }
        }
        //药物节点
        Node node1 = new Node();
        node1.setAttributes(null);
        node1.setSize(15);
        node1.setCategory(0);
        node1.setName(drugName);
        node1.setId(drugName);
        nodes.add(node1);
        //相关蛋白节点
        List<String> proteinNames = drugDao.selectProteinName(data);
        for (int i =0;i<proteinNames.size();i++){
            Node node2 = new Node();
            node2.setAttributes(null);
            node2.setSize(15);
            node2.setCategory(1);
            node2.setId(proteinNames.get(i));
            node2.setName(proteinNames.get(i));
            nodes.add(node2);
        }
        //酶节点
        List<String> enzymeNames1 = drugDao.selectEnzymeByProteins(data);//通过所有的相关蛋白查到的直接有关系的所有酶
        int enzymeSize1 = 0;
        int enzymeSize2 = 0;
        enzymeSize2 = enzymeNames1.size();
        while(enzymeSize2>enzymeSize1){
            List<String> enzymeTemp1 = drugDao.selectEnzymeByEnzyme(enzymeNames1);
            enzymeNames1 = enzymeTemp1;
            enzymeSize1 = enzymeSize2;
            enzymeSize2 = enzymeNames1.size();
        }
        //经过while循环查找得到的酶是酶-酶对应关系的所有酶
        //通过下面的循环把通过相关蛋白-酶的对应关系找到的酶添加进来
        List<String> enzymeTemp2 = drugDao.selectEnzymeByProteins(data);
        for(int i=0;i<enzymeTemp2.size();i++){
            if(!enzymeNames1.contains(enzymeTemp2.get(i))){
                enzymeNames1.add(enzymeTemp2.get(i));
            }
        }
        //List<String> enzymeNames = drugDao.selectEnzymeName(data);
        for(int i=0;i<enzymeNames1.size();i++){
            Node node3 = new Node();
            node3.setAttributes(null);
            node3.setSize(15);
            node3.setCategory(2);
            node3.setId(enzymeNames1.get(i));
            node3.setName(enzymeNames1.get(i));
            nodes.add(node3);
        }
        //代谢物节点
        List<String> metaboliteNames = drugDao.selectMetabolites(enzymeNames1);
        for(int i = 0;i<metaboliteNames.size();i++){
            Node node4 = new Node();
            node4.setAttributes(null);
            node4.setSize(15);
            node4.setCategory(3);
            node4.setId(metaboliteNames.get(i));
            node4.setName(metaboliteNames.get(i));
            nodes.add(node4);
        }
        return nodes;
    }

    @Override
    public List<Link> setLinks(String drugName) {
        List<Link> links = new ArrayList<>();
        DrugVo drugVo = new DrugVo();
        ProteinEnzymeVo proteinEnzymeVo = new ProteinEnzymeVo();
        ProteinEnzymeVo proteinProteinVo = new ProteinEnzymeVo();
        ProteinEnzymeVo enzymeEnzymeVo = new ProteinEnzymeVo();
        EnzymeMetVo enzymeMetVo = new EnzymeMetVo();
        //查询得到药物-相关蛋白的关系
        List<DrugVo> drugVos = drugDao.selectDrugAndProtein(drugName);
        for(int i=0;i<drugVos.size();i++){
            Link link = new Link();
            drugVo = drugVos.get(i);
            link.setSource(drugVo.getDname());
            link.setTarget(drugVo.getPname());
            links.add(link);
        }
        //查询得到蛋白-蛋白的关系
        List<String> data = drugDao.selectProteins(drugName);
        int size1 = 0;
        int size2 = data.size();
        while (size2>size1){
            List<String> temp = drugDao.selectProteinsByList(data);
            data = temp;
            size1 = size2;
            size2 = data.size();
        }
        List<String> temp2 = drugDao.selectProteins(drugName);
        for(int j=0;j<temp2.size();j++){
            if(!data.contains(temp2.get(j))){
                data.add(temp2.get(j));
            }
        }
        List<ProteinEnzymeVo> proteinToProtein = drugDao.selectProteinToProtein(data);
        for(int i = 0;i<proteinToProtein.size();i++){
            Link link = new Link();
            proteinProteinVo = proteinToProtein.get(i);
            link.setSource(proteinProteinVo.getPname());
            link.setTarget(proteinProteinVo.getPname_e());
            links.add(link);
        }
        //查询得到蛋白-酶的关系
        List<String> enzymeNames1 = drugDao.selectEnzymeByProteins(data);//通过所有的相关蛋白查到的直接有关系的所有酶
        int enzymeSize1 = 0;
        int enzymeSize2 = 0;
        enzymeSize2 = enzymeNames1.size();
        while(enzymeSize2>enzymeSize1){
            List<String> enzymeTemp1 = drugDao.selectEnzymeByEnzyme(enzymeNames1);
            enzymeNames1 = enzymeTemp1;
            enzymeSize1 = enzymeSize2;
            enzymeSize2 = enzymeNames1.size();
        }
        //经过while循环查找得到的酶是酶-酶对应关系的所有酶
        //通过下面的循环把通过相关蛋白-酶的对应关系找到的酶添加进来
        List<String> enzymeTemp2 = drugDao.selectEnzymeByProteins(data);
        for(int i=0;i<enzymeTemp2.size();i++){
            if(!enzymeNames1.contains(enzymeTemp2.get(i))){
                enzymeNames1.add(enzymeTemp2.get(i));
            }
        }
        Map<String,Object> proteinEnzymeMap = new HashMap<>();
        proteinEnzymeMap.put("proteins",data);
        proteinEnzymeMap.put("enzymes",enzymeNames1);
        List<ProteinEnzymeVo> proteinEnzymeVos = drugDao.selectProteinAndEnzyme(proteinEnzymeMap);
        for(int i = 0;i<proteinEnzymeVos.size();i++){
            Link link = new Link();
            proteinEnzymeVo = proteinEnzymeVos.get(i);
            link.setSource(proteinEnzymeVo.getPname());
            link.setTarget(proteinEnzymeVo.getPname_e());
            links.add(link);
        }
        //查询得到酶-酶的关系
        List<ProteinEnzymeVo> enzymeEnzymeVos = drugDao.selectEnzymeToEnzyme(enzymeNames1);
        for(int i = 0;i<enzymeEnzymeVos.size();i++){
            Link link = new Link();
            enzymeEnzymeVo = enzymeEnzymeVos.get(i);
            link.setSource(enzymeEnzymeVo.getPname());
            link.setTarget(enzymeEnzymeVo.getPname_e());
            links.add(link);
        }
        //查询得到酶-代谢物的关系
        List<EnzymeMetVo> enzymeMetVos = drugDao.selectEnzymeMet(enzymeNames1);
        for(int i=0;i<enzymeMetVos.size();i++){
            Link link = new Link();
            enzymeMetVo = enzymeMetVos.get(i);
            link.setSource(enzymeMetVo.getEname());
            link.setTarget(enzymeMetVo.getMname());
            links.add(link);
        }
        return links;
    }
}
