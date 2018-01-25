package com.xhj.dddrug.dao;

import java.util.List;

/**
 * User: asus
 * Date: 2018/1/26
 * Time: 0:07
 * Version:V1.0
 */
public interface DrugMapper {
    public List<String> selectProteins(String drugname);

    public List<String> selectMetabolites(String drugname);

    public List<String> selectReference(String drugname);
}
