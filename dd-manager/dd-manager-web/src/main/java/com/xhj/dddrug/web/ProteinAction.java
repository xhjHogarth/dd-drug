package com.xhj.dddrug.web;

import com.xhj.dddrug.dto.Order;
import com.xhj.dddrug.dto.Page;
import com.xhj.dddrug.dto.Result;
import com.xhj.dddrug.pojo.Drug;
import com.xhj.dddrug.pojo.Metabolite;
import com.xhj.dddrug.pojo.Protein;
import com.xhj.dddrug.pojo.ResultProtein;
import com.xhj.dddrug.service.ProteinService;
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
 * Date: 2018/2/6
 * Time: 23:36
 * Version:V1.0
 */
@Controller
public class ProteinAction {

    @Autowired
    public ProteinService proteinService;

    @RequestMapping("/proteinDetail.action")
    public String proteinDetail(HttpServletRequest request){
        ResultProtein resultProtein = new ResultProtein();
        String type = request.getParameter("type");
        String gene_symbol = request.getParameter("gene_symbol");
        //先根据相关蛋白的简称和药物的类型，把相关蛋白的所有信息查到
        Protein protein = proteinService.selectProtein(type,gene_symbol);
        resultProtein.setProtein(protein);
        //根据相关蛋白去查找所有的药物和代谢物
        Map<String,Object> map = new HashMap<>();
        map.put("type",protein.getType());
        map.put("data",protein);
        List<Drug> drugs = proteinService.selectDrugs(map);
        resultProtein.setDrugs(drugs);
        try {
            List<Metabolite> metabolites = proteinService.selectMetabolites(map);
            resultProtein.setMetabolites(metabolites);
            request.setAttribute("resultProtein",resultProtein);
            return "proteinDetail";
        } catch (Exception e) {
            request.setAttribute("resultProtein",resultProtein);
            return "proteinDetailError";
        }
    }

    @RequestMapping("listDrugs.action")
    public String listDrugs(HttpServletRequest request){
        String pname = request.getParameter("pname").trim();
        String type = request.getParameter("type").trim();
        request.setAttribute("pname",pname);
        request.setAttribute("type",type);
        return "drugList";
    }

    @ResponseBody
    @RequestMapping(value = "drugs/{pname}/{type}",method = RequestMethod.GET)
    public Result<Drug> listDrug(@PathVariable("pname") String pname, @PathVariable("type") String type, Page page, Order order){
        Map<String,Object> map = new HashMap<>();
        Protein protein = new Protein();
        protein.setGene_symbol(pname);
        protein.setType(type);
        map.put("data",protein);
        map.put("type",type);
        map.put("page",page);
        map.put("order",order);
//        System.out.println("--------------");
//        System.out.println(map.toString());
//        System.out.println("--------------");
        Result<Drug> result = proteinService.selectDrugsByPage(map);
        return result;
    }

    @RequestMapping("proteinGraph.action")
    public String proteinGraph(HttpServletRequest request){
        String pname = request.getParameter("pname").trim();
        String type = request.getParameter("type").trim();
        Map<String,Object> map = new HashMap<>();
        Protein protein = new Protein();
        protein.setGene_symbol(pname);
        map.put("data",protein);
        map.put("type",type);
        List<Node> nodes = proteinService.setNodes(map);
        map.put("data",protein);
        List<Link> links = proteinService.setLinks(map);
        Graph graph = new Graph();
        graph.setNodes(nodes);
        graph.setLinks(links);
        String graphStr = JsonUtils.objectToJson(graph);
        request.setAttribute("graph",graphStr);
        request.setAttribute("pname",pname);
        request.setAttribute("type",type);
        return "proteinGraph";
    }

    @RequestMapping("listMetabolites.action")
    public String listMetabolites(HttpServletRequest request){
        String pname = request.getParameter("pname").trim();
        String type = request.getParameter("type").trim();
        request.setAttribute("pname",pname);
        request.setAttribute("type",type);
        return "metabolitesList2";
    }

    @ResponseBody
    @RequestMapping(value = "metabolites/{pname}/{type}",method = RequestMethod.GET)
    public Result<Metabolite> listMetabolites(@PathVariable("pname") String pname,@PathVariable("type") String type,
                                              Page page,Order order){
        Result<Metabolite> result = new Result<>();
        Map<String,Object> map = new HashMap<>();
        Protein protein = new Protein();
        protein.setGene_symbol(pname);
        protein.setType(type);
        map.put("data",protein);
        map.put("page",page);
        map.put("order",order);
        map.put("type",type);
        result = proteinService.selectMetabolitesByPage(map);
        return result;
    }

    @ResponseBody
    @RequestMapping(value = "listEdges2/{pname}/{type}",method = RequestMethod.GET)
    public Result<Link> listEdges(@PathVariable("pname")String pname,@PathVariable("type")String type,Page page){
        Result<Link> result = new Result<>();
        Map<String,Object> map = new HashMap<>();
        Protein protein = new Protein();
        protein.setGene_symbol(pname);
        protein.setType(type);
        map.put("data",protein);
        map.put("type",type);
        map.put("page",page);
        try {
            result = proteinService.listEdges(map);
        }catch (Exception e){
            e.printStackTrace();
        }
        return  result;
    }
}
