package com.xhj.dddrug.service;

import java.util.List;

/**
 * User: asus
 * Date: 2018/1/26
 * Time: 0:06
 * Version:V1.0
 */
public interface DrugService {
    public List<String> selectProteins(String drugname);

    public List<String> selectMetabolites(String drugName);

    public List<String> selectReference(String drugName);
}
