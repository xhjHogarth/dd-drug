package com.xhj.dddrug.web;

import com.xhj.dddrug.pojo.Metabolite;
import com.xhj.dddrug.pojo.Protein;
import com.xhj.dddrug.pojo.Reference;
import com.xhj.dddrug.pojo.ResultDrug;
import com.xhj.dddrug.service.DrugService;
import com.xhj.dddrug.utils.Graph;
import com.xhj.dddrug.utils.JsonUtils;
import com.xhj.dddrug.utils.Link;
import com.xhj.dddrug.utils.Node;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * User: asus
 * Date: 2018/1/26
 * Time: 0:06
 * Version:V1.0
 */
@Controller
public class DrugAction {

    @Autowired
    private DrugService drugService;

    @RequestMapping("/drugDetail.action")
    public String drugDetail(HttpServletRequest request){
        ResultDrug resultDrug = new ResultDrug();
        resultDrug.setDrugName("Methotrexate");
        resultDrug.setType("hepatotoxicity");
        String drugbank = drugService.selectDrugBank(resultDrug);
        resultDrug.setDrugBank(drugbank);
        List<Protein> proteins = drugService.selectProteins(resultDrug);
        resultDrug.setProteins(proteins);
        List<Metabolite> metabolites = drugService.selectMetabolites(resultDrug);
        resultDrug.setMetabolites(metabolites);
        List<Reference> references = drugService.selectReference(resultDrug);
        resultDrug.setReferences(references);
        request.setAttribute("resultDrug",resultDrug);
        return "drugdetail";
    }

    @RequestMapping("/drugGraph.action")
    public String drugGraph(HttpServletRequest request){
        String drugName = request.getParameter("drugName");
        String type = request.getParameter("type");
        ResultDrug resultDrug = new ResultDrug();
        resultDrug.setDrugName(drugName);
        resultDrug.setType(type);
        List<Node> nodes = drugService.setNodes(resultDrug);
        List<Link> links = drugService.setLinks(resultDrug);
        Graph graph = new Graph();
        graph.setNodes(nodes);
        graph.setLinks(links);
        String graphStr = JsonUtils.objectToJson(graph);
        request.setAttribute("drugName",drugName);
        request.setAttribute("graph",graphStr);
        request.setAttribute("type",type);
        return "drugGraph";
    }
}
