package com.xhj.dddrug.web;

import com.xhj.dddrug.dto.Order;
import com.xhj.dddrug.dto.Page;
import com.xhj.dddrug.dto.Result;
import com.xhj.dddrug.pojo.*;
import com.xhj.dddrug.service.DrugService;
import com.xhj.dddrug.utils.Graph;
import com.xhj.dddrug.utils.JsonUtils;
import com.xhj.dddrug.utils.Link;
import com.xhj.dddrug.utils.Node;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        String drugName = request.getParameter("drugName");
        String type = request.getParameter("type");
        resultDrug.setDrugName(drugName);
        resultDrug.setType(type);
        String drugbank = drugService.selectDrugBank(resultDrug);
        if("".equals(drugbank) || drugbank==null){
            drugbank = "<a>"+drugName+"</a>";
        }else {
            String drugbankStr = "<a href=\"https://www.drugbank.ca/drugs/"+drugbank+"\" style=\"margin-left: 20px\">"+drugName+"</a>";
            drugbank = drugbankStr;
        }
        resultDrug.setDrugBank(drugbank);
        List<Protein> proteins = drugService.selectProteins(resultDrug);
        resultDrug.setProteins(proteins);
        List<Reference> references = drugService.selectReference(resultDrug);
        resultDrug.setReferences(references);
        try {
            List<Metabolite> metabolites = drugService.selectMetabolites(resultDrug);
            resultDrug.setMetabolites(metabolites);
            request.setAttribute("resultDrug",resultDrug);
            return "drugdetail";
        } catch (Exception e) {
            request.setAttribute("resultDrug",resultDrug);
            return "drugdetailError";
        }
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

    @RequestMapping("drugBrowse.action")
    public String drugBrowse(HttpServletRequest request){
        String type = request.getParameter("type");
        request.setAttribute("type",type);
        return "Browse";
    }

    @ResponseBody
    @RequestMapping(value = "drugBrowse/{type}",method = RequestMethod.GET)
    public Result<Drug> drugResult(@PathVariable("type")String type, Page page, Order order){
        Result<Drug> result = new Result<>();
        Map<String,Object> map = new HashMap<>();
        map.put("type",type);
        map.put("page",page);
        map.put("order",order);
        result = drugService.drugBrowse(map);
        return result;
    }
}
