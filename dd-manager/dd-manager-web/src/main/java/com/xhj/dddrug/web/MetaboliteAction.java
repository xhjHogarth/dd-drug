package com.xhj.dddrug.web;

import com.xhj.dddrug.dto.Order;
import com.xhj.dddrug.dto.Page;
import com.xhj.dddrug.dto.Result;
import com.xhj.dddrug.pojo.Drug;
import com.xhj.dddrug.pojo.Metabolite;
import com.xhj.dddrug.pojo.Protein;
import com.xhj.dddrug.pojo.ResultMetabolite;
import com.xhj.dddrug.service.MetaboliteService;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class MetaboliteAction {

    @Autowired
    public MetaboliteService metaboliteService;

    @RequestMapping("metaboliteDetail.action")
    public String metaboliteDetail(HttpServletRequest request){
        ResultMetabolite resultMetabolite = new ResultMetabolite();
        Metabolite metabolite = new Metabolite();
        Map<String,Object> map = new HashMap<>();
//        metabolite.setMname("Acetate");
//        metabolite.setType("hepatotoxicity");
//        metabolite.setHmdb("HMDB0000042");
//        metabolite.setKc("C00033");
        String mname = request.getParameter("mname");
        String type = request.getParameter("type");
        metabolite = metaboliteService.selectMetabolie(mname,type);
        map.put("data",metabolite);
        map.put("type",metabolite.getType());
        resultMetabolite.setMetabolite(metabolite);
        try {
            resultMetabolite = metaboliteService.listMetabolite(map,resultMetabolite);
            request.setAttribute("resultMetabolite",resultMetabolite);
            return "metaboliteDetail";
        } catch (Exception e) {
            request.setAttribute("resultMetabolite",resultMetabolite);
            return "metaboliteDetailError";
        }
    }

    @RequestMapping("listDrugs2.action")
    public String listDrugs(HttpServletRequest request){
        String mname = request.getParameter("mname");
        String type = request.getParameter("type");
        request.setAttribute("mname",mname);
        request.setAttribute("type",type);
        return "drugList2";
    }

    @ResponseBody
    @RequestMapping(value = "drugs2/{mname}/{type}",method = RequestMethod.GET)
    public Result<Drug> listDrug(@PathVariable("mname")String mname, @PathVariable("type")String type, Page page, Order order){
        Result<Drug> result = new Result<>();
        Map<String,Object> map = new HashMap<>();
        Metabolite metabolite = new Metabolite();
        metabolite.setMname(mname);
        metabolite.setType(type);
        map.put("data",metabolite);
        map.put("type",type);
        map.put("page",page);
        map.put("order",order);
        result = metaboliteService.listDrugs(map);
        return result;
    }

    @RequestMapping("listProtein2.action")
    public String listProteins(HttpServletRequest request){
        String mname = request.getParameter("mname");
        String type = request.getParameter("type");
        request.setAttribute("mname",mname);
        request.setAttribute("type",type);
        return "proteinList2";
    }

    @ResponseBody
    @RequestMapping(value = "proteins2/{mname}/{type}",method = RequestMethod.GET)
    public Result<Protein> listProtein(@PathVariable("mname")String mname, @PathVariable("type")String type, Page page, Order order){
        Result<Protein> result = new Result<>();
        Map<String,Object> map = new HashMap<>();
        Metabolite metabolite = new Metabolite();
        metabolite.setMname(mname);
        metabolite.setType(type);
        map.put("data",metabolite);
        map.put("type",type);
        map.put("page",page);
        map.put("order",order);
        result = metaboliteService.listProtein(map);
        return result;
    }

    @RequestMapping("metaboliteGraph.action")
    public String metaboliteGraph(HttpServletRequest request){
        String mname = request.getParameter("mname").trim();
        String type = request.getParameter("type").trim();
        request.setAttribute("mname",mname);
        request.setAttribute("type",type);
        Metabolite metabolite = new Metabolite();
        metabolite.setMname(mname);
        metabolite.setType(type);
        List<Node> nodes = new ArrayList<>();
        List<Link> links = new ArrayList<>();
        Graph graph = new Graph();
        Map<String,Object> map = new HashMap<>();
        map.put("data",metabolite);
        map.put("type",type);
        nodes = metaboliteService.setNodes(map);
        map.put("data",metabolite);
        links = metaboliteService.setLinks(map,metabolite);
        graph.setNodes(nodes);
        graph.setLinks(links);
        String graphStr = JsonUtils.objectToJson(graph);
        request.setAttribute("graph",graphStr);
        return "metaboliteGraph";
    }

    @ResponseBody
    @RequestMapping(value = "listEdges3/{mname}/{type}",method = RequestMethod.GET)
    public Result<Link> listEdge(@PathVariable("mname")String mname,@PathVariable("type")String type,Page page){
        Result<Link> result = new Result<>();
        Metabolite metabolite = new Metabolite();
        metabolite.setMname(mname);
        metabolite.setType(type);
        Map<String,Object> map = new HashMap<>();
        map.put("data",metabolite);
        map.put("type",type);
        map.put("page",page);
        result = metaboliteService.listEdgeByPage(map,metabolite);
        return result;
    }
}
