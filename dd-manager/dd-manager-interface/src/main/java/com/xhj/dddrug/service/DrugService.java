package com.xhj.dddrug.service;

import com.xhj.dddrug.dto.Order;
import com.xhj.dddrug.dto.Page;
import com.xhj.dddrug.dto.Result;
import com.xhj.dddrug.pojo.Metabolite;
import com.xhj.dddrug.pojo.Protein;
import com.xhj.dddrug.pojo.Reference;
import com.xhj.dddrug.pojo.ResultDrug;
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
    public List<Protein> selectProteins(ResultDrug drug);

    public List<Metabolite> selectMetabolites(ResultDrug drug);

    public List<Reference> selectReference(ResultDrug drug);

    public String selectDrugBank(ResultDrug drug);

    public List<Node> setNodes(ResultDrug drug);

    public List<Link> setLinks(ResultDrug drug);

    public Result<Metabolite> listMetabolites(ResultDrug drug, Page page, Order order);

    public Result<Reference> listReferences(ResultDrug drug, Page page, Order order);

    public Result<Link> listEdges(ResultDrug drug,Page page);
}
