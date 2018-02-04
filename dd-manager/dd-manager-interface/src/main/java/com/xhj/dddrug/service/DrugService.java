package com.xhj.dddrug.service;

import com.xhj.dddrug.utils.Link;
import com.xhj.dddrug.utils.Node;

import java.util.List;

/**
 * User: asus
 * Date: 2018/1/26
 * Time: 0:06
 * Version:V1.0
 */
public interface DrugService {
    //得到的是部分用于展示的相关蛋白的数据
    public List<String> selectProteins(String drugname);

    public List<String> selectMetabolites(String drugName);

    public List<String> selectReference(String drugName);

    public String selectDrugBank(String drugName);

    public List<Node> setNodes(String drugName);

    public List<Link> setLinks(String drugName);
}
