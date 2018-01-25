package com.xhj.dddrug.service.impl;

import com.xhj.dddrug.dao.DrugMapper;
import com.xhj.dddrug.service.DrugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
        List<String> data = drugDao.selectProteins(drugname);
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
        List<String> data = drugDao.selectMetabolites(drugName);
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
}
